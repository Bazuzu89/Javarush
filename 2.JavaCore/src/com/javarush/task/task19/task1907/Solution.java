package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();
        try (BufferedReader fileReader =new BufferedReader (new FileReader(fileName))) {
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher;
            int count = 0;
            while (fileReader.ready()) {
                matcher = pattern.matcher(fileReader.readLine());
                while (matcher.find()) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
