package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;
import java.io.*;
import java.net.*;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s присоединился к чату", userName));
        }
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("%s покинул чат", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized(Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    String messageData = Client.this.getUserName();
                    connection.send(new Message(MessageType.USER_NAME, messageData));
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            try {
                String address = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

    }

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ioe) {
            ConsoleHelper.writeMessage("Произошел сбой подключения");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        try {
            synchronized (this) {
            wait();
            notify();
            }
        } catch (InterruptedException ie) {
            ConsoleHelper.writeMessage("Соединение прервано");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено.\nДля выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String newLine = ConsoleHelper.readString();
            if (newLine.equals("exit")) {
                break;
            } else if (shouldSendTextFromConsole()) {
                sendTextMessage(newLine);
            }

        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
