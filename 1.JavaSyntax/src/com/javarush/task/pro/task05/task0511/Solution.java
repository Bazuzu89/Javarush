package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двухмерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш кодScanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        multiArray = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            multiArray[i] = new int[size];
        }
    }
}
