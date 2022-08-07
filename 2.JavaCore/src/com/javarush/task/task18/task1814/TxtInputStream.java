package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    private FileInputStream fis;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException {
        super (fileName);

        if (fileName.endsWith(".txt")) {
            this.fis = new FileInputStream(fileName);
        }
        else if (!fileName.endsWith(".txt")) {
            try {super.close();} catch (IOException e) {e.printStackTrace();}
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
        try {
            new TxtInputStream("C:\\Users\\SPG-NOTE\\Desktop\\Задания от ЮВ\\Совет директоров СПГТ\\2021.11.18 СД ГСПГТ уведомление\\Приложение_1.pdf");
        } catch (IOException | UnsupportedFileNameException e) {}
    }
}

