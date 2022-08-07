package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = new ByteArrayInputStream(args[0].getBytes());
        System.setIn(is);
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerFileName.readLine();
        BufferedReader readerFromFile = new BufferedReader(new FileReader(fileName));
            int s;
            int count = 0;
            while (!((s = readerFromFile.read()) == -1)) {
                char symbol = (char) s;
                if (('a' <= symbol && symbol <= 'z') || ('A' <= symbol && symbol <= 'Z')) {
                    count++;
                }
            }
            System.out.println(count);
        is.close();
        readerFileName.close();
        readerFromFile.close();
    }
}
