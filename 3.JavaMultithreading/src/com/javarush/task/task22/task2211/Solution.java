package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileInputName = args[0];
        String fileOutputName = args[1];
        try (FileInputStream reader = new FileInputStream(fileInputName);
            FileOutputStream writer = new FileOutputStream(fileOutputName)) {

            byte[] bufferInput = new byte[reader.available()];
            int i = 0;
            while (reader.available() > 0) {
                bufferInput[i] = (byte) (reader.read());
                i++;
            }
            String inputString = new String(bufferInput, "windows-1251");
            byte[] bufferOutput = inputString.getBytes(StandardCharsets.UTF_8);

            writer.write(bufferOutput);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
