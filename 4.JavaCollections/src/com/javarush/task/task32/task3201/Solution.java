package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
            RandomAccessFile raf = new RandomAccessFile(String.valueOf(args[0]),"rw");
            if (Integer.parseInt(args[1]) > raf.length()) {
                raf.seek(raf.length());
            }
            else raf.seek(Integer.parseInt(args[1]));
            raf.write(args[2].getBytes());

    }
}
