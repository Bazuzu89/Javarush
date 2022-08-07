package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;
import java.util.Scanner;


/* 
Делим массив
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        //напишите тут ваш код

        int[] firstHalf;
        int[] secondHalf;
        int[] firstHalf1;
        int[] secondHalf1;
        int length = array.length;
        int point = (int) Math.ceil(length / 2);
        if (length % 2 == 0)
            {
                firstHalf = new int[length/2];
                secondHalf = new int[length/2];
                firstHalf = Arrays.copyOfRange(array, 0, length / 2);
                secondHalf = Arrays.copyOfRange(array, array.length / 2, length);
                result[0] = Arrays.copyOf(firstHalf, array.length / 2);
                result[1] = Arrays.copyOf(secondHalf, array.length / 2);
            }
        else {
            firstHalf1 = new int[point+1];
            secondHalf1 = new int[array.length - point + 1];
            firstHalf1 = Arrays.copyOfRange(array, 0, point + 1);
            secondHalf1 = Arrays.copyOfRange(array, point + 1, length);
            result[0] = Arrays.copyOf(firstHalf1, point + 1);
            result[1] = Arrays.copyOf(secondHalf1, array.length - point - 1);
        }
        System.out.println(Arrays.deepToString(result));
        }




    }

