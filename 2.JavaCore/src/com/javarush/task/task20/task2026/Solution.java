package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        boolean isInsideRectangle = false;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                int width = 0;
                int length = 0;
                if (a[i][j] == 1) {
                    count++;
                    isInsideRectangle = true;
                    int k = i+1;
                    while (isInsideRectangle) {
                        if (k == a[0].length || a[k][j] == 0) {
                            isInsideRectangle = false;
                            width = k;
                        }
                        k++;
                    }
                    isInsideRectangle = true;
                    k = j + 1;
                    while (isInsideRectangle) {
                        if (k == a.length  || a[i][k] == 0) {
                            isInsideRectangle = false;
                            length = k;
                        }
                        k++;
                    }
                }
                for (int l = i; l < width; l++) {
                    for (int m = j; m < length; m++) {
                        a[l][m] = 0;
                    }
                }
            }
        }
        return count;
    }
}
