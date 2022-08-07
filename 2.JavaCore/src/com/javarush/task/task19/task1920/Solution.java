package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {

        // String fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        TreeMap<String, Double> treeMap = new TreeMap();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] unit = fileReader.readLine().split(" ");
                if (treeMap.containsKey(unit[0])) {
                    double value = treeMap.get(unit[0]);
                    double newValue = value + Double.parseDouble(unit[1]);
                    treeMap.put(unit[0], newValue);
                } else {
                    treeMap.put(unit[0], Double.parseDouble(unit[1]));
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        ArrayList<String> resultArray = new ArrayList<>();

        double maxValue = 0;

        for (String string : treeMap.keySet()) {
            if (treeMap.get(string) > maxValue) {
                maxValue = treeMap.get(string);
            }
        }

        for (String string : treeMap.keySet()) {
            if (treeMap.get(string) == maxValue) {
                resultArray.add(string);
            }
        }

        for (String string : resultArray) {
            System.out.println(string);
        }

    }
}
