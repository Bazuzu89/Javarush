package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

import static java.lang.Integer.parseInt;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        String text = args[2];
        byte[] array = new byte[text.length()];

        raf.seek(Long.parseLong(args[1]));
        raf.read(array, 0, text.length());
        String newText = new String(array, 0, text.length());
        if (text.equals(newText)) {
            raf.seek(raf.length());
            raf.write("true".getBytes());
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }
    }
}
