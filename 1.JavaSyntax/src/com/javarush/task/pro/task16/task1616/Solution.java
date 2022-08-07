package com.javarush.task.pro.task16.task1616;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingTime());
    }

    static TreeSet<String> getSortedZones() {
        //напишите тут ваш код
        TreeSet<String> zones = new TreeSet<>();
        for (String zone : ZoneId.getAvailableZoneIds()) {
            zones.add(zone);
        }
        return zones;
    }

    static ZonedDateTime getBeijingTime() {
        //напишите тут ваш код
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime timeBeijing = ZonedDateTime.now(zone);
        return timeBeijing;
    }
}
