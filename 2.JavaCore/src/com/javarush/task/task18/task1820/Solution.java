package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));

        String file1Name = readerFileName.readLine();
        String file2Name = readerFileName.readLine();

        try (BufferedReader file1Reader = new BufferedReader(new FileReader(file1Name));
             BufferedWriter file2Writer = new BufferedWriter(new FileWriter(file2Name))) {
            while (file1Reader.ready()) {
                String[] stringArray = file1Reader.readLine().split(" ");
                String[] resultStringArray = new String[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    float number = Float.valueOf(stringArray[i]);
                    int resultNumber = Math.round(number);
                    resultStringArray[i] = String.valueOf(resultNumber);
                }
                for (int i = 0; i < resultStringArray.length; i++) {
                    file2Writer.write(resultStringArray[i] + " ");
                }
            }
        }
    }
}
