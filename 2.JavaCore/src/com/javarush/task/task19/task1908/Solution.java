package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        String file1Name = "";
        String file2Name = "";
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1Name = fileNameReader.readLine();
            file2Name = fileNameReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1Name));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2Name))) {
            ArrayList<String> numbers = new ArrayList<>();
            while (fileReader.ready()) {
                String[] parts = fileReader.readLine().split(" ");
                for (int i = 0; i < parts.length; i++) {
                    char[] chars = parts[i].toCharArray();
                    boolean isNumeric = true;
                    for (int j = 0; j < chars.length; j++) {
                        if (!(chars[j] <= 57 && chars[j] >= 48)) {
                            isNumeric = false;
                        }
                    }
                    if (isNumeric) {
                        numbers.add(parts[i]);
                    }
                }
            }
            for (String number : numbers) {
                fileWriter.write(number + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
