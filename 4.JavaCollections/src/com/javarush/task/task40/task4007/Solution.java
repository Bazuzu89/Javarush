package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date)  {
        //напишите тут ваш код
        Calendar cal = Calendar.getInstance();
        String[] dateArray = date.split(" ");
        try {
            if (dateArray.length == 2) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy HH:mm:ss", Locale.ENGLISH);
                Date d = sdf.parse(date);
                cal.setTime(d);
                System.out.println("День: " + cal.get(Calendar.DATE));
                System.out.println("День недели: " + ((cal.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : (cal.get(Calendar.DAY_OF_WEEK) - 1)));
                System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (cal.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + cal.get(Calendar.YEAR));
                System.out.println("AM или PM: " + (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + cal.get(Calendar.HOUR));
                System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
                System.out.println("Секунды: " + cal.get(Calendar.SECOND));
            } else {
                String[] shortDateArray = date.split("\\.");
                if (shortDateArray.length == 3) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.M.yyyy", Locale.ENGLISH);
                    Date d = sdf.parse(date);
                    cal.setTime(d);
                    System.out.println("День: " + cal.get(Calendar.DATE));
                    System.out.println("День недели: " + ((cal.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : (cal.get(Calendar.DAY_OF_WEEK) - 1)));
                    System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
                    System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
                    System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
                    System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
                    System.out.println("Месяц: " + (cal.get(Calendar.MONTH) + 1));
                    System.out.println("Год: " + cal.get(Calendar.YEAR));
                } else {
                    String[] thirdDateArray = date.split(":");
                    if (thirdDateArray.length == 3) {
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                        Date d = sdf.parse(date);
                        cal.setTime(d);
                        System.out.println("AM или PM: " + (cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                        System.out.println("Часы: " + cal.get(Calendar.HOUR));
                        System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
                        System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
                        System.out.println("Секунды: " + cal.get(Calendar.SECOND));
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
