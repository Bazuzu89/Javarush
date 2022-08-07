package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        changeBytes();

    }

    public static void changeBytes () {
        Scanner scanner = new Scanner(System.in);
        try (InputStream input = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream output = Files.newOutputStream(Path.of(scanner.nextLine()))) {

            byte[] buffer = input.readAllBytes();

            for (int i =0; i < buffer.length; i = i + 2) {
                if (i == buffer.length - 1) {break;}
                byte temp = buffer[i];
                buffer[i] = buffer[i+1];
                buffer[i+1] = temp;
            }

            output.write(buffer);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

