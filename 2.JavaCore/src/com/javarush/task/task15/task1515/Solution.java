package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    public static void main(String[] args) {

        System.out.println(min(A, B));

    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            A = Integer.valueOf(bufferedReader.readLine());
            B = Integer.valueOf(bufferedReader.readLine());
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
