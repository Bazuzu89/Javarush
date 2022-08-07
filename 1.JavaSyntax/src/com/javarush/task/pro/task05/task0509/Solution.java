package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class Solution {

    public static int[][] MULTIPLICATION_TABLE = new int[10][10];

    public static void main(String[] args) {
        //напишите тут ваш код

        for (int i = 0; i < 10; i++)
        {
            for (int k = 0; k < 10; k++)
            {
                MULTIPLICATION_TABLE[i][k] = (i+1) * (k+1);
            }

        }
        for (int i = 0; i < 10; i++)
        {
            for (int k = 0; k < 10; k++)
            {
                System.out.print(MULTIPLICATION_TABLE[i][k]+" ");
            }
            System.out.println("");
        }
    }
}
