package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String fileName = "";
        ArrayList<String> fileDataStrings = new ArrayList<>();
        ArrayList<String> resultFileDataStrings = new ArrayList<>();

        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = fileNameReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                fileDataStrings.add(fileReader.readLine());
            }

            for (String string : fileDataStrings) {
                String[] array = string.split(" ");


                for (int i = 0; i < array.length; i++) {
                    try {
                        String checkString = array[i];
                        Boolean endsWithDot = array[i].endsWith(".");
                        if (endsWithDot) {
                            checkString = array[i].substring(0, array[i].length() - 1);
                        }

                        if (map.keySet().contains(Integer.parseInt(checkString))) {
                            array[i] = map.get(Integer.parseInt(checkString));
                            if (endsWithDot) {
                                array[i] = array[i] + ".";
                            }
                        }
                    } catch (NumberFormatException nfe) {
                        continue;
                    }
                }

                String newString = String.join(" ", array);

                resultFileDataStrings.add(newString);
            }

            for (String string : resultFileDataStrings) {
                System.out.println(string);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
