package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        String[] array = url.split("\\?");
        String[] newArray = array[1].split("&");
        String[] resultArray = new String[newArray.length];
        for (int i = 0; i < newArray.length; i++) {

            if (!(newArray[i].indexOf("=")== -1))
            {
                resultArray[i] = newArray[i].substring(0, newArray[i].indexOf("="));
            } else {
                resultArray[i] = newArray[i];
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i].contains("obj")) {
                int length = newArray[i].length();
                try {
                    alert(Double.valueOf(newArray[i].substring(newArray[i].indexOf("=") + 1, length)));
                } catch (Exception e) {
                    alert(String.valueOf(newArray[i].substring(newArray[i].indexOf("=") + 1, length)));
                }

            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
