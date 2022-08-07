package com.javarush.task.pro.task16.task1604;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1989, 7, 27);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        SimpleDateFormat date = new SimpleDateFormat("EEEE", Locale.forLanguageTag("RU"));
        String dateDate = date.format(calendar.getTime());

        return dateDate;
    }
}
