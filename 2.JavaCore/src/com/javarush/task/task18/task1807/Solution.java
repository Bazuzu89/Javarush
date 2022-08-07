package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine())
        ) {
            while (fis.available() > 0) {
                if (fis.read() == 44) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
