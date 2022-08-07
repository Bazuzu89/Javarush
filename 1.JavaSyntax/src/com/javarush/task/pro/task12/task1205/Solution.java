package com.javarush.task.pro.task12.task1205;

/* 
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        //напишите тут ваш код
        if ((a > 0 && b == 0) // +число/ноль
        || ((a == Double.POSITIVE_INFINITY && b >= 0) && (b != Double.POSITIVE_INFINITY) // +бесконечность/+число
                || ((a == Double.NEGATIVE_INFINITY && b <= 0) && (b != Double.NEGATIVE_INFINITY)))) // -бесконечность/-число
        {
            System.out.println("Infinity");
        }
        else if ((a < 0 && b == 0) // -/0
                || (a == Double.NEGATIVE_INFINITY && b >= 0 && b != Double.POSITIVE_INFINITY) // -бесконечность/+число
                || (a == Double.POSITIVE_INFINITY && b < 0 && b != Double.NEGATIVE_INFINITY)) // +бесконечность/-число
        {
            System.out.println("-Infinity");
        }
        else if ((a == 0 && b == 0) // два нуля
                || (a == Double.NaN || b == Double.NaN)    //две неопределенности
                || (a == Double.POSITIVE_INFINITY && b == Double.NEGATIVE_INFINITY) // две бесконечности +/-
                || (a == Double.POSITIVE_INFINITY && b == Double.POSITIVE_INFINITY) // две бесконечности +/+
                || (a == Double.NEGATIVE_INFINITY && b == Double.NEGATIVE_INFINITY) // две бесконечности -/-
                || (a == Double.NEGATIVE_INFINITY && b == Double.POSITIVE_INFINITY)) // две бесконечности -/+
        {
            System.out.println("NaN");
        }
        else {
            System.out.println(a / b);
        }
    }
}
