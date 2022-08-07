package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public volatile static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!((s = readerFileName.readLine()).equals("exit"))) {
            new ReadThread(s);
        }
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            this.start();
                    }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
                byte[] array = new byte[255];
                while (reader.ready()) {
                    array[reader.read()]++;
                }


                for (int i = 0; i < array.length; i++) {
                    if (array[i] > maxCount) {
                        maxCount = array[i];
                    }
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == maxCount) {
                        resultMap.put(fileName, i);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
