package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {

            s = reader.readLine();
            try {
            if (s.equalsIgnoreCase("exit")) {
                break;
            } else if (s.contains(".")) {
                Double output = Double.parseDouble(s);
                print(output);
            } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                short output = (short) Integer.parseInt(s);
                print(output);
            } else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) {
                Integer output = Integer.parseInt(s);
                print(output);
            }
        }
            catch (Exception e) {
                print(s);
            }
           }





            /* if (s.equalsIgnoreCase("exit")) {
                break;
            } else {
                if (s.contains(".")) {
                    Double output = Double.parseDouble(s);
                    print(output);
                } else {
                    int checkS = Integer.parseInt(s);
                    if (checkS > 0 && checkS < 128) {
                        short output = (short) checkS;
                        print(output);
                    } else if (checkS <= 0 || checkS >= 128) {
                        Integer output = (Integer) checkS;
                        print(output);
                    }
                    else print(s);
                }

            } */

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
