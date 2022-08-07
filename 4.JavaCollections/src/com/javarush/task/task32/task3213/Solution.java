package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        String string = decode(reader, -3);
        System.out.println(string);  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) {
            return new String();
        } else {
        BufferedReader br = new BufferedReader(reader);
        String text = br.readLine();
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) ((int)array[i] + key);
        }
        String line = "";
        for (int i = 0; i < array.length; i++) {
            line = line + array[i];
        }
        return line;
        }
    }
}
