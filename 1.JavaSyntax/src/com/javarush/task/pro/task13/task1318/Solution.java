package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.DECEMBER));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        //напишите тут ваш код
        int index = month.ordinal();
        if (index == Month.values().length - 1) {return Month.values()[0];}
        return Month.values()[index+1];
    }
}
