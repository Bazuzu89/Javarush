package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        List<String> resultData = new ArrayList<String>();
        try (BufferedReader reader1File = new BufferedReader(new FileReader(file1Name));
            BufferedReader reader2File = new BufferedReader(new FileReader(file2Name)))  {

            String r;
            while (!((r = reader2File.readLine()) == null)) {
                resultData.add(r);
            }

            String s;
            while (!((s = reader1File.readLine()) == null)) {
                resultData.add(s);
            }
        }

        try (BufferedWriter resultWriter = new BufferedWriter(new FileWriter(file1Name))) {
            for (String string : resultData) {
                resultWriter.write(string);
            }
        }
    }
}
