package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = readerFileName.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName)))
            {} catch (FileNotFoundException fnfe) {
                System.out.println(fileName);
                break;
            }
        }

    }
}
