package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.List;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerFileName.readLine();
        String fileName3 = readerFileName.readLine();
        String fileName2 = readerFileName.readLine();

        readerFileName.close();





        BufferedReader readerFile3 = new BufferedReader(new FileReader(fileName3));
        FileWriter writerFile3ToFile1 = new FileWriter(fileName1);

        while (readerFile3.ready()) {
            writerFile3ToFile1.write(readerFile3.read());
        }

        readerFile3.close();
        writerFile3ToFile1.close();


        BufferedReader readerFile2 = new BufferedReader(new FileReader(fileName2));
        FileWriter writerFile2ToFile1 = new FileWriter(fileName1, true);

        while (readerFile2.ready()) {
            writerFile2ToFile1.write(readerFile2.read());
        }
        readerFile2.close();
        writerFile2ToFile1.close();
    }
}
