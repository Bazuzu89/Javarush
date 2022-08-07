package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/* 
Генератор паролей
*/

public class Solution {


    public static void main(String[] args) {

            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());


    }

    public static ByteArrayOutputStream getPassword() {
        char[] upperCaseArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowerCaseArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numeralsArray = "0123456789".toCharArray();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        Boolean isPasswordGenerated = false;
        while (!isPasswordGenerated) {
        String password = "";
        for (int i = 0; i < 8; i++) {
            int whichLine = (int) (Math.random() * 3 + 1);
            switch (whichLine) {
                case 1:
                    password = password + upperCaseArray[(int) (Math.random() * (upperCaseArray.length))];
                    continue;
                case 2:
                    password = password + lowerCaseArray[(int) (Math.random() * (lowerCaseArray.length))];
                    continue;
                case 3:
                    password = password + numeralsArray[(int) (Math.random() * (numeralsArray.length))];
                    continue;
                }
            }
            Pattern pattern1 = Pattern.compile("[a-z]");
            Matcher matcher1 = pattern1.matcher(password);

            Pattern pattern2 = Pattern.compile("[A-Z]");
            Matcher matcher2 = pattern2.matcher(password);

            Pattern pattern3 = Pattern.compile("[0-9]");
            Matcher matcher3 = pattern3.matcher(password);

           if (matcher1.find() && matcher2.find() && matcher3.find()) {            // дописать регексы
           isPasswordGenerated = true;
               PrintStream print = new PrintStream(result);
               print.print(password);
           }
        }
        return result;
    }
}
