package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Arrays;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream inputStream1 = new FileInputStream(reader.readLine());
                FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
                FileOutputStream outputStream3 = new FileOutputStream(reader.readLine())
                ) {
            byte[] buffer = new byte[2 * inputStream1.available()];
            int count = 0;
            while (inputStream1.available() > 0) {
                count = inputStream1.read(buffer);
            }
            int firstFile = 0;
            if (count % 2 == 0) {
                firstFile = count/2;
            } else {
                firstFile = count/2 + 1;
            }
            outputStream2.write(buffer, 0, firstFile);
            outputStream3.write(buffer, firstFile, count - firstFile );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
