package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        String s;
        String newFileName = "";
        while (!(s = fileNameReader.readLine()).equals("end")) {
            String[] tempArray = s.split(".part");
            newFileName = tempArray[0];
            int fileNumber = Integer.valueOf(tempArray[tempArray.length - 1]);
            sortedMap.put(fileNumber, s);
        }

        Set<Integer> keySet = sortedMap.keySet();
        for (Integer key : keySet) {
            try (FileInputStream fileReader = new FileInputStream(sortedMap.get(key));
                 FileOutputStream fileWriter = new FileOutputStream(newFileName)) {
                byte[] buffer = new byte[fileReader.available() + 10];
                int count = fileReader.read(buffer);
                fileWriter.write(buffer, 0, count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
