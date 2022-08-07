package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;
import java.util.Date;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate current = LocalDate.now();
        return current;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate date = LocalDate.of(2020, 9 , 12);
        return date;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate date = LocalDate.of(2020, 9, 12);
        int yearDay = date.getDayOfYear();
        LocalDate dateOfYearDay = LocalDate.ofYearDay(2020, yearDay);
        return dateOfYearDay;
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        long unixDate = LocalDate.of(2020,9,12).toEpochDay();
        LocalDate date = LocalDate.ofEpochDay(unixDate);
        return date;
    }
}
