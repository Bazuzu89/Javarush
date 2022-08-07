package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = fileNameReader.readLine();
        String file2Name = fileNameReader.readLine();
        fileNameReader.close();
        try (FileReader fileReader = new FileReader(file1Name);
             FileWriter fileWriter = new FileWriter(file2Name)) {
            int count = 0;
            while(fileReader.ready()) {
                count++;
                if (count % 2 == 0) {
                    int byteToWrite = fileReader.read();
                    fileWriter.write(byteToWrite);
                } else {
                    fileReader.read();
                }
            }
        }
    }
}
