package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String[] dateArray = date.split(" ");
        if (dateArray.length == 2) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("d.M.yyyy");
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("H:mm:ss");
            LocalDate ld = LocalDate.parse(dateArray[0], df);
            LocalTime lt = LocalTime.parse(dateArray[1], tf);
            System.out.println("День: " + ld.getDayOfMonth());
            System.out.println("День недели: " + ld.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + ld.getDayOfMonth());
            System.out.println("День года: " + ld.getDayOfYear());
            System.out.println("Неделя месяца: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + ld.getMonth().getValue());
            System.out.println("Год: " + ld.getYear());
            System.out.println("AM или PM: " + (lt.getHour() < 12 ? "AM" : "PM"));
            System.out.println("Часы: " + lt.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + lt.getHour());
            System.out.println("Минуты: " + lt.getMinute());
            System.out.println("Секунды: " + lt.getSecond());
        } else {
            if (date.split("\\.").length == 3) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("d.M.yyyy");
                LocalDate ld = LocalDate.parse(date, df);
                System.out.println("День: " + ld.getDayOfMonth());
                System.out.println("День недели: " + ld.get(ChronoField.DAY_OF_WEEK));
                System.out.println("День месяца: " + ld.getDayOfMonth());
                System.out.println("День года: " + ld.getDayOfYear());
                System.out.println("Неделя месяца: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
                System.out.println("Неделя года: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
                System.out.println("Месяц: " + ld.getMonth().getValue());
                System.out.println("Год: " + ld.getYear());
            } else {
                if (date.split(":").length == 3) {
                    DateTimeFormatter tf = DateTimeFormatter.ofPattern("H:mm:ss");
                    LocalTime lt = LocalTime.parse(date, tf);
                    System.out.println("AM или PM: " + (lt.getHour() < 12 ? "AM" : "PM"));
                    System.out.println("Часы: " + lt.get(ChronoField.CLOCK_HOUR_OF_AMPM));
                    System.out.println("Часы дня: " + lt.getHour());
                    System.out.println("Минуты: " + lt.getMinute());
                    System.out.println("Секунды: " + lt.getSecond());
                }
            }
        }
    }
}
