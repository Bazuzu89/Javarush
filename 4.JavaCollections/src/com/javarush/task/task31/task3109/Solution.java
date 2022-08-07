package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try {
            Properties properties = new Properties();
            String[] fileNameArray = fileName.split("\\.");
            if (fileNameArray[fileNameArray.length - 1].equalsIgnoreCase("xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileInputStream(fileName));
            }
            return properties;

        } catch (FileNotFoundException fnfe) {
            return new Properties();
        } catch (IOException ioe) {
            return new Properties();
        }
    }
}
