package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        //String file1Name = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        //String file2Name = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест2.txt";

        try (BufferedReader file1Reader = new BufferedReader(new FileReader(args[0]));
             FileWriter file2Writer = new FileWriter(args[1])) {
            while (file1Reader.ready()) {
                String[] array = file1Reader.readLine().split(" ");
                for (int i = 0; i < array.length; i++) {
                    Pattern pattern = Pattern.compile("\\d");
                    Matcher matcher = pattern.matcher(array[i]);
                    if (matcher.find()) {
                        file2Writer.write(array[i] + " ");
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
