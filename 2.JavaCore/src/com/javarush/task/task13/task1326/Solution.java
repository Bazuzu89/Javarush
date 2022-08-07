package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;

        ArrayList<Integer> array = new ArrayList<>();
        try {
        fileInputStream = new FileInputStream(scanner.nextLine());
        reader = new BufferedReader(new InputStreamReader(fileInputStream, "US-ASCII" ));
        String s;
        while ((s = reader.readLine()) != null) {

            array.add(Integer.parseInt(s));

        }
        int[] intArray = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            intArray[i] = array.get(i);
        }
        Arrays.sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
           if(intArray[i] % 2 == 0)
           System.out.println(intArray[i]);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
