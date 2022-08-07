package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест2.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) {
            return new StringWriter();
        } else {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            while (bufferedReader.ready()) {
                String append = bufferedReader.readLine();
                line = line + append;
            }

            StringWriter writer = new StringWriter();
            writer.write(line);
            return writer;
        }
    }
}
