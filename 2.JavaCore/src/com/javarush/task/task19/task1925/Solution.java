package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        // String file1Name = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        // String file2Name = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест2.txt";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            ArrayList<String> resultArray = new ArrayList<>();
            while (fileReader.ready()) {
                String[] stringsArray = fileReader.readLine().split("\\s");
                for (int i = 0; i < stringsArray.length; i++) {
                    if (stringsArray[i].length() > 6) {
                        resultArray.add(stringsArray[i]);
                    }
                }
            }

            String resultString = String.join(",", resultArray);

            fileWriter.write(resultString);


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
