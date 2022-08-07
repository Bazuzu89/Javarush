package com.javarush.task.pro.task06.task0608;

/* 
Кубический калькулятор
*/

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        long result = cube(17);
        System.out.println(result);

    }

    //напишите тут ваш код
    public static long cube (long number)
    {
        int degree = 3;
        long times = 1;
        for (int i = 0; i < degree; i++)
        {
            times = times * number;
        }
        return times;
    }
}
