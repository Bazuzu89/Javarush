package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle((CashMachine.class.getPackage().getName() + "/resources/common_en").replaceAll("\\.", "/"), Locale.ENGLISH);

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String string = null;
        try {
             string = bis.readLine();
            if (string.equalsIgnoreCase("exit")) {
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("operation.EXIT"));
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String currencyCode;

        writeMessage(res.getString("choose.currency.code"));
        currencyCode = readString();
        if (currencyCode.length() != 3) {
            return null;
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] numbers;
            try {
                writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
                numbers= readString().split(" ");
                if (numbers.length != 2) {

                    return null;
                }
                int denomination = Integer.parseInt(numbers[0]);
                int count = Integer.parseInt(numbers[1]);
                if (denomination <= 0 || count <= 0) {

                    return null;
                }
            } catch (NumberFormatException numberFormatException) {

                return null;
            }
        return numbers;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation;
        do {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            try {
                Integer operationCode = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(operationCode);
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
                operation = null;
            }
        } while (operation == null);
        return operation;
    }
}
