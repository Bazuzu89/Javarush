package com.javarush.task.pro.task16.task1618;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* 
Лишь бы не запутаться
*/

public class Solution {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromDateTime, ZoneId fromZone, ZoneId toZone) {
        /*напишите тут ваш код
        int oldHours = ZonedDateTime.now(fromZone).getHour();
        int newHours = ZonedDateTime.now(toZone).getHour();
        int oldMinutes = ZonedDateTime.now(fromZone).getMinute();
        int newMinutes = ZonedDateTime.now(toZone).getMinute();
        int diffH = newHours - oldHours;
        int diffM = newMinutes - oldMinutes;
        LocalDateTime newDateTime = fromDateTime.plusHours(diffH).plusMinutes(diffM);
        ZonedDateTime newZoneTime = ZonedDateTime.of(newDateTime, toZone);
        LocalDateTime result = newZoneTime.toLocalDateTime();
         */
        ZonedDateTime oldTime = ZonedDateTime.of(fromDateTime, fromZone);
        ZonedDateTime newTime = oldTime.withZoneSameInstant(toZone);
        LocalDateTime time = newTime.toLocalDateTime();
        return time;
    }
}
