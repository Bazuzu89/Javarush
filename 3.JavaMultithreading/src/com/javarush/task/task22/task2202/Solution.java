package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(
        getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] array = string.split(" ");
        if (array.length < 5) {
            throw new TooShortStringException();
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            newString.append(array[i]);
            newString.append(' ');
        }

        // String[] endArray = array[4].split("[\\pP\\s]");
        // newString.append(endArray[0]);
        return newString.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
