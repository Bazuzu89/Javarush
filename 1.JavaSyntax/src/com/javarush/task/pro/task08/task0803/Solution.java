package com.javarush.task.pro.task08.task0803;


import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        //напишите тут ваш код
        int a = ints[0];
        for (int i = 0; i < 9; i++)
        {
           a = Math.min(a, ints[i+1]);
        }
        return a;
    }

    public static int[] getArrayOfTenElements() {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
        {
            array[i] = scanner.nextInt();
        }

        return array;
    }
}
