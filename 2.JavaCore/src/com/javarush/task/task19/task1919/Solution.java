package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();

            while (bufferedReader.ready()) {
                String[] array = bufferedReader.readLine().split(" ");
                names.add(array[0]);
                values.add(array[1]);
            }

            SortedMap<String, Double> sortedMap = new TreeMap<String, Double>();
            for (int i = 0; i < names.size(); i++) {
                if (!sortedMap.containsKey(names.get(i))) {
                    double value = 0;
                for (int j = 0; j < names.size(); j++) {
                    if (names.get(i).equals(names.get(j))) {
                        value = value + Double.parseDouble(values.get(j));
                    }
                }
                sortedMap.put(names.get(i), value);
                }
            }

            for (String name : sortedMap.keySet()) {
                System.out.println(name + " " + sortedMap.get(name));
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
