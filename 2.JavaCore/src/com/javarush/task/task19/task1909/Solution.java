package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        String file1Name = " ";
        String file2Name = " ";
        try (BufferedReader fileNameReader = new BufferedReader (new InputStreamReader(System.in))) {
            file1Name = fileNameReader.readLine();
            file2Name = fileNameReader.readLine();
        } catch (IOException e) {e.printStackTrace();}

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1Name));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2Name))) {
            while (fileReader.ready()) {
                int symbol = fileReader.read();
                if (symbol == 46) {
                    symbol = 33;
                }
                fileWriter.write(symbol);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
