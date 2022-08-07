package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream instance;
    public QuestionFileOutputStream (AmigoOutputStream instance) {
        this.instance = instance;
    }

    @Override
    public void flush() throws IOException {
        this.instance.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.instance.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.instance.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.instance.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Вы действительно хотите закрыть поток? Д/Н");
            if (reader.readLine().equals("Д")) {
                this.instance.close();
            }
        }
    }
}

