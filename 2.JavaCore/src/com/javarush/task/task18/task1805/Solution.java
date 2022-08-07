package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new TreeSet<Integer>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine())) {

            while (fis.available() > 0) {
                set.add(fis.read());
            }
            List<Integer> list = new ArrayList<Integer>(set);
            list.sort(Comparator.naturalOrder());
            set = new LinkedHashSet(list);

        }
        for (Integer setUnit : set) {
            System.out.print(setUnit + " ");
        }
    }
}
