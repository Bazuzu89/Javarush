package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        FileOutputStream output = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String s = null;
       try {
           Scanner scanner = new Scanner(System.in);
           String fileName = scanner.nextLine();
           output = new FileOutputStream(fileName);
           bufferedWriter = new BufferedWriter(new OutputStreamWriter(output, "UTF-8" ));
           while (!(s = scanner.nextLine()).equals("exit")) {
               bufferedWriter.write(s);
               bufferedWriter.newLine();
           }
           bufferedWriter.write(s);
       } catch (IOException e) {
           e.printStackTrace();
       }
       finally {
           try {
               bufferedWriter.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {

               output.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
