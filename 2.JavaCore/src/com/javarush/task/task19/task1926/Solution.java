package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                StringBuilder line = new StringBuilder(fileReader.readLine());
                System.out.println(line.reverse());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
