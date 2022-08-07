package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String resultString = "";
        int radix = 0;
        if (s.startsWith("0")) {
            if (s.startsWith("0x")) {
                radix = 16;
                resultString = s.substring(2);
            }
            if (s.startsWith("0b")) {
                radix = 2;
                resultString = s.substring(2);
            }
            if (s.matches("\\d+")) {
                radix = 8;
                resultString = s.substring(1);
            }
        } else {
            radix = 10;
            resultString = s;
        }

        return String.valueOf(Integer.parseInt(resultString, radix));
    }
}
