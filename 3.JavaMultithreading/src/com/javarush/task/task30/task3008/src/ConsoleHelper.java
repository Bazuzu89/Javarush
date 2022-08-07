package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException ioe) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            result = readString();
        }
        return result;
    }

    public static int readInt() {
        int result = 0;
        try {
            result = Integer.parseInt(readString());
        } catch (NumberFormatException nfe) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            result = readInt();
        }
        return result;
    }
}
