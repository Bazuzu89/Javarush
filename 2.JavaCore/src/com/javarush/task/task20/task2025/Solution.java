package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;
        int size = String.valueOf(N).length();
        long[] pows = new long[9];
        for (int i = 0; i < pows.length; i++) {
            pows[i] = (long) Math.pow(i+1, size);
        }





















        /*
        ArrayList<Long> tempArray = new ArrayList<Long>();
        long i = 1;
        int j = 0;
        while (i < N) {
            long equatedNumber = 0;
            long currentN = i;
            String stringCurrentN = String.valueOf(currentN);
            int size = stringCurrentN.length();
            char[] charArray = stringCurrentN.toCharArray();
            for (int k = 0; k < charArray.length; k++) {
                equatedNumber = equatedNumber + (long) Math.pow(Character.getNumericValue(charArray[k]), size);
            }

            long equatedNumber = 0;
            long currentN = i;
            int size = String.valueOf(currentN).length();

            int ai = 0;
            while (currentN > 0) {
                ai = (int) currentN % 10;
                currentN = (currentN - ai) / 10;
                equatedNumber = equatedNumber + (long) (Math.pow(ai, size));
            }
            if (i == equatedNumber) {
                tempArray.add(equatedNumber);
                j++;
            }
            i++;
        }
        result = new long[tempArray.size()];
        int l = 0;
        for (Long number : tempArray) {
            result[l] = number;
            l++;
        } */
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
