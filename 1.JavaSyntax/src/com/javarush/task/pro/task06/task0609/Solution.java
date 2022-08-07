package com.javarush.task.pro.task06.task0609;

/* 
Кубический калькулятор в кубе
*/

public class Solution {
    public static void main(String[] args) {
    ninthDegree(10);
        System.out.println(ninthDegree(10));
    }

    public static long cube(long a){
        return a*a*a;
    }

    //напишите тут ваш код
    public static long ninthDegree(long number)
    {
        long middleResult = cube (number);
        long result = cube (middleResult);
        return result;
    }
}
