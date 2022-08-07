package com.javarush.task.task30.task3008;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message receivedMessage = connection.receive();
            while (!(receivedMessage.getType().equals(MessageType.USER_NAME))
                    || (receivedMessage.getData().equals(""))
                    || connectionMap.keySet().contains(receivedMessage.getData())) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                receivedMessage = connection.receive();
            }
            String nameConnection = receivedMessage.getData();
            connectionMap.put(nameConnection, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Пользователь добавлен"));
            return nameConnection;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receivedMessage = connection.receive();
                if (receivedMessage.getType() == MessageType.TEXT) {
                    Message newMessage = new Message(MessageType.TEXT, String.format("%s: %s", userName, receivedMessage.getData()));
                    sendBroadcastMessage(newMessage);
                } else {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage(String.format("Установлено новое удаленное соединение с адресом %s", socket.getRemoteSocketAddress().toString()));
            String newClientName = null;
            try (Connection connection = new Connection(socket)) {
                newClientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClientName));
                notifyUsers(connection, newClientName);
                serverMainLoop(connection, newClientName);
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }
            finally {
                if (newClientName != null) {
                    connectionMap.remove(newClientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClientName));
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (String name : connectionMap.keySet()) {
                connectionMap.get(name).send(message);
            }
        } catch (IOException ioe) {
            ConsoleHelper.writeMessage("Невозможно отправить сообщение.");
        }
    }
}
