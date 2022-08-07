package com.javarush.task.task30.task3008.client;

import java.io.*;
import com.javarush.task.task30.task3008.*;
import java.text.*;
import java.util.*;


public class BotClient extends Client {
    public class BotSocketThread extends Client.SocketThread {
        public void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] array = message.split(": ");
            if (array.length != 2)  return;
                String format = null;
                switch (array[1]) {
                    case "дата": {
                        format = "d.MM.YYYY";
                        break;
                    }
                    case "день": {
                        format = "d";
                        break;
                    }
                    case "месяц": {
                        format = "MMMM";
                        break;
                    }
                    case "год": {
                        format = "YYYY";
                        break;
                    }
                    case "время": {
                        format = "H:mm:ss";
                        break;
                    }
                    case "час": {
                        format = "H";
                        break;
                    }
                    case "минуты": {
                        format = "m";
                        break;
                    }
                    case "секунды": {
                        format = "s";
                        break;
                    }
                }
                if (format != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    BotClient.this.sendTextMessage(String.format("Информация для %s: %s", array[0], sdf.format(Calendar.getInstance().getTime())));
                }
        }
    }

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
