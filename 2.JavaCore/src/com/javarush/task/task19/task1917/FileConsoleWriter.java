package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    public static void main(String[] args) {

    }

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {

        this.fileWriter = new FileWriter(fileName);

    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {

        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {

        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {

        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {

        this.fileWriter = new FileWriter(fd);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        char[] newCbuf = new char[len];
        for (int i = 0; i < len; i++) {
            newCbuf[i] = cbuf[i + off];
        }
        System.out.println(newCbuf);
    }


    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off+len));
    }


    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        String string = "";
        for (int i = 0; i < cbuf.length; i++) {
            string = string + cbuf[i];
        }
        System.out.println(string);
    }


    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }


    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }


    public void close() throws IOException {
        this.fileWriter.close();
    }
}
