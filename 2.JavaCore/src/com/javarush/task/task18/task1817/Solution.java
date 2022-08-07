package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        float countAllSymbols = 0;
        float countSpaces = 0;
        int symbol;
        while (!((symbol = fileReader.read()) == -1)) {
            countAllSymbols++;
            if ((char) symbol == ' ') {
                countSpaces++;
            }
        }
        float result = countSpaces / countAllSymbols * 100;
        System.out.printf("%.2f", result);
        fileReader.close();
    }
}
