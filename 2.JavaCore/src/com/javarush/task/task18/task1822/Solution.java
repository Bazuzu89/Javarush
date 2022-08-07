package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args)  throws IOException {
        //InputStream is = new ByteArrayInputStream("C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\1Тест.txt".getBytes());
        //System.setIn(is);
        BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerFileName.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String s = reader.readLine();
                String[] arrayString = s.split(" ");
                String ID = arrayString[0];
                if (ID.equals(args[0])) {
                    System.out.println(s);
                }
            }
        }
    }
}
