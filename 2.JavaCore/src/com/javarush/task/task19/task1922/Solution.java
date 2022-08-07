package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        //String fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        //InputStream is = new ByteArrayInputStream(fileName.getBytes());
        //System.setIn(is);
        ArrayList<String> stringList = new ArrayList<>();
        try (BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(readerFileName.readLine()))) {
            while (fileReader.ready()) {
                stringList.add(fileReader.readLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        ArrayList<String> resultArray = new ArrayList<>();

        for (String string : stringList) {
            int count = 0;
            String[] stringArray = string.split(" ");
            for (int i = 0; i < stringArray.length; i++ ) {
                for (int j = 0; j < words.size(); j++) {
                    if (stringArray[i].equals(words.get(j))) {
                        count++;
                    }
                }
            }

            if (count == 2) {
                // resultArray.add(string);
                System.out.println(string);
            }
        }

        /* for (String string : resultArray) {
            System.out.println(string);
        } */

    }
}
