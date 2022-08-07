package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        for (String key : runtimeStorage.keySet()) {
            properties.setProperty(key, runtimeStorage.get(key));
        }
        properties.store(outputStream,"");
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Object key : properties.keySet()) {
            runtimeStorage.put(String.valueOf(key), String.valueOf(properties.get(key)));
        }
    }

    public static void main(String[] args) {
        /* String fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Пропертиз.properties";
        InputStream is = new ByteArrayInputStream(fileName.getBytes());
        System.setIn(is); */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
