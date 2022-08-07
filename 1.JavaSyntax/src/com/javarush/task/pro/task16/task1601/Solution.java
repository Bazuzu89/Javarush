package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник:)
*/

public class Solution {

    static Date birthDate = new Date (89, 7, 27);


    public static void main(String[] args) {

        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        /* String[] russianWeek = {"Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
        String dayOfBirth = russianWeek[birthDate.getDay()];
        return dayOfBirth; */
        SimpleDateFormat newDate = new SimpleDateFormat("EEEE", Locale.forLanguageTag("RU"));
        String day = newDate.format(date);
        return day;
    }
}
