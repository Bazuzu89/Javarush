package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int countTabs = 0;
        int off = 0;
        int end = 0;
        for (int i =0; i < string.length(); i++) {

            if ((Character) (string.charAt(i)) == (Character) ('\t') && countTabs == 0) {
                countTabs++;
                off = i;
                continue;
            }
            if ((Character) (string.charAt(i)) == (Character) ('\t') && countTabs == 1) {
                countTabs++;
                end = i;
                break;
            }
        }
        if (countTabs < 2) {
            throw new TooShortStringException();
        } else
        return string.substring(off + 1, end);


    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(
        getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
