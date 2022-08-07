package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix (int q) {

    }

    public static void printMatrix (int q, int w, int e) {

    }

    public static void printMatrix (double inT) {

    }

    public static void printMatrix (double a, double b) {

    }

    public static void printMatrix (int a, double b) {

    }

    public static void printMatrix () {

    }

    public static void printMatrix (double q, int w) {

    }

    public static void printMatrix (String s, int m) {

    }
}
