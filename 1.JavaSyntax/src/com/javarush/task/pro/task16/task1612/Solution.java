package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        //напишите тут ваш код
        Set<LocalDate> setKey = sourceMap.keySet();
        Iterator<Map.Entry<LocalDate, List<LocalTime>>> itr = sourceMap.entrySet().iterator();
        Set<LocalDateTime> dateSet = new HashSet<>();
           while (itr.hasNext()) {
            Map.Entry<LocalDate, List<LocalTime>> entry = itr.next();
            LocalDate key = entry.getKey();
            List<LocalTime> value = entry.getValue();

            for (LocalTime time : value) {
                LocalDateTime localDateTime = LocalDateTime.of(key, time);
                dateSet.add(localDateTime);
            }

        }
        return dateSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}