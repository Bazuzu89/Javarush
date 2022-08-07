package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number1 = Integer.valueOf(reader.readLine());
            int number2 = Integer.valueOf(reader.readLine());
            if (!(number1 > 0 && number2 >0)) {
                System.out.println("Видимо ты особенный мальчик, числа должны быть положительными!");
            }
            int maxDividerNumber = 1;
            for (int i = 1; i <= Math.min(number1, number2); i++) {
                if ((number1 % i == 0) && (number2 % i == 0)) {
                    maxDividerNumber = i;
                }
            }
            System.out.println(maxDividerNumber);
        } catch (NumberFormatException e) {
            System.out.println("Ты ввёл не число, мой юный олигофрен!");
        }



    }
}
