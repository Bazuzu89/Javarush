package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {

        if (!(args[0].equals("-e") || args[0].equals("-d"))) return;
                try (FileInputStream fis = new FileInputStream(String.valueOf(args[1]));
                     FileOutputStream fos = new FileOutputStream(String.valueOf(args[2]))) {

                    byte[] inputBuffer = new byte[fis.available() * 2];
                    int count = fis.read(inputBuffer);
                    byte[] outputBuffer = new byte[count];
                    for (int i = 0; i < count; i++) {
                        outputBuffer[i] = inputBuffer[count - 1 - i];
                    }
                    fos.write(outputBuffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }





    }

}
