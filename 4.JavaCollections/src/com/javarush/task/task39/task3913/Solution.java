package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\SPG-NOTE\\Desktop\\Обучение\\Разраб\\Тест"));
        /* System.out.println(logParser.getNumberOfUniqueIPs(null, null) + "\n");
        System.out.println(logParser.getIPsForUser("Diego", null, null) + "\n");
        System.out.println(logParser.getIPsForEvent(Event.LOGIN, null, null) + "\n");
        System.out.println(logParser.getIPsForStatus(Status.OK, null, null));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, null));
        System.out.println(logParser.getNumberOfUserEvents("Diego", null, null));
        System.out.println(logParser.getUsersForIP("127.0.0.1", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, null));
        System.out.println(logParser.getWroteMessageUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null, 15) + "\n\n\n\n\n");
        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo", 18, null, null));
        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null));

        System.out.println(Event.SOLVE_TASK.toString()); */

        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}