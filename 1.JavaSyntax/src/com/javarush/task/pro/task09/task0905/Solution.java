package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        if (decimalNumber <= 0) {return 0;}
        int a0 = decimalNumber % 8; // коэффициент нулевого разряда
        int a = 1;
        int x = decimalNumber - a0;
        int resultOctalNumber = a0; // результирующее число
        int i = 1;
        while (x > 0)
        {
            a =  (x/8) % 8;
            x = x / 8 - a;
            resultOctalNumber = (int) (resultOctalNumber + a * Math.pow(10, i));
            i++;
        }
        return resultOctalNumber;
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        if (octalNumber <= 0) {return 0;}
        int a0 = octalNumber % 10;
        int i = 1;
        int a = 1;
        int x = octalNumber - a0;
        int resultDecimalNumber = a0;
        while (x > 0)
        {
            a = (x/10) % 10;
            x = x / 10 - a;
            resultDecimalNumber = (int) (resultDecimalNumber + a * Math.pow(8, i));
            i++;
        }
        return resultDecimalNumber;
    }
}
