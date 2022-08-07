package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\1Тест.txt";
    private FileOutputStream fis;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream fis) throws FileNotFoundException {
        super (fileName);
        this.fis = fis;

    }

    @Override
    public void close() throws IOException {
        this.fis.flush();
        String signature = "JavaRush © All rights reserved.";
        byte[] buffer = signature.getBytes(StandardCharsets.UTF_8);
        this.fis.write(buffer);
        this.fis.close();


    }

    @Override
    public void write(int b) throws IOException {
        this.fis.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.fis.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.fis.write(b);
    }

    @Override
    public void flush() throws IOException {
        this.fis.flush();
    }
}
