package com.javarush.task.task18.task1809;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())
        ) {
            byte[] buffer = new byte[fileInputStream.available() * 2];
            int count = fileInputStream.read(buffer);
            byte[] bufferOutput = new byte[count];
            for (int i = 0; i < count; i++) {
                bufferOutput[i] = buffer[i];
            }
            byte[] middleMan = new byte[bufferOutput.length];
            for (int i = bufferOutput.length - 1; i >= 0; i--) {
                middleMan[(bufferOutput.length - 1) - i] = bufferOutput[i];
            }
            fileOutputStream.write(middleMan);
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
