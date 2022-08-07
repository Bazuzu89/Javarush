package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable throwException(Enum message) {
        Throwable result;
        if (message == null) {
            return new IllegalArgumentException();
        }
        String exceptionMessage = message.toString().replace("_"," ").toLowerCase();
        String withoutFirstLetter = exceptionMessage.substring(1);
        String firstLetter = exceptionMessage.substring(0, 1).toUpperCase();
        exceptionMessage = firstLetter + withoutFirstLetter;
        if (message instanceof ApplicationExceptionMessage) {
            result = new Exception(exceptionMessage);
        } else if (message instanceof DatabaseExceptionMessage) {
            result = new RuntimeException(exceptionMessage);
        } else if (message instanceof UserExceptionMessage) {
            result = new Error(exceptionMessage);
        } else {
            result = new IllegalArgumentException();
        }
        return result;
    }
}
