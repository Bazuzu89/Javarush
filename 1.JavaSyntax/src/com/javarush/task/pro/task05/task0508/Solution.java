package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        strings = new String[6];
        boolean[] compare = new boolean[6];
        for (int i = 0; i < strings.length; i++) //считывание строк
        {
            strings[i] = scanner.nextLine();
        }

        for (int i = 0; i < strings.length; i++) //внешний цикл сравнения
        {
            int count = 0;  //счетчик повторений
            if (strings[i] == null)
            {
                continue;
            }
            for (int k = 0; k < strings.length; k++) //внутренний цикл сравнения
            {
                if (strings[k] == null) //убрать налл
                {
                    continue;
                }
                if (i == k) // не сравнивать само с собой
                {
                    continue;
                }
                else if (strings[i].equals(strings[k])) //записать в массив сравнения повторки
                {
                    compare[k] = true;
                    count++;
                }
            }
            for (int k = 0; k < compare.length; k++) //записать в исходный массив налл
            {
                if (compare[k])
                {
                    strings[k] = null;
                    if (count > 0)
                    {
                        strings[i] = null;
                    }
                }
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
