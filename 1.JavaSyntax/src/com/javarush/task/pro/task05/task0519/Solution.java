package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

/* 
Есть ли кто?
*/

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 5;

    public static void main(String[] args) {
        //напишите тут ваш код
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            sortedArray[i] = array[i];
        }
        boolean condition;
        Arrays.sort(sortedArray);
        int index = Arrays.binarySearch(sortedArray, element);
        if (index >= 0)
        {
            condition = true;
        }
        else
        {
            condition = false;
        }
        System.out.println(condition);
    }
}
