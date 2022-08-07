package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = null;
        FileInputStream input = null;
        InputStreamReader isr = null;

        try {
            Scanner scanner = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(System.in));
            input = new FileInputStream(reader.readLine());
            isr = new InputStreamReader(input, "UTF-8");
            int i = 0;
            while((i = isr.read()) != -1) {
                System.out.print((char)i);
            }
            /* while(input.available()>0) {
                System.out.print((char)input.read());
            } */

        }
        catch (IOException e) {
            System.out.println("что-то пошло не так");
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}