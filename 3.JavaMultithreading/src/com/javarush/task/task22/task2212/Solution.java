package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) {
            return false;
        }

        Pattern pattern1 = Pattern.compile("[^\\d\\+\\(\\)]");
        Matcher matcher1 = pattern1.matcher(telNumber);
        if (matcher1.find()) {
            return false;
        }

        if (telNumber.length() == 13) {
            Pattern pattern = Pattern.compile("^\\+\\d{11}\\d$");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.find();
        }
        if (telNumber.length() == 15) {
            Pattern pattern = Pattern.compile("^\\+\\d+\\(\\d{3}\\)\\d+\\d$");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.find();
        }
        if (telNumber.length() == 12) {
            Pattern pattern = Pattern.compile("^\\d*\\(\\d{3}\\)\\d+\\d$");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.find();
        }
        if (telNumber.length() == 10) {
            Pattern pattern = Pattern.compile("\\d{10}");
            Matcher matcher = pattern.matcher(telNumber);
            return matcher.find();
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("05012(456)37"));
    }
}
