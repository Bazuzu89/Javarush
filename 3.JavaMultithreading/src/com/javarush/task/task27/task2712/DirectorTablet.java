package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.*;
import com.javarush.task.task27.task2712.statistic.event.*;
import java.util.*;
import com.javarush.task.task27.task2712.ad.*;
import com.javarush.task.task27.task2712.kitchen.*;
import java.time.format.*;
import java.text.*;
import com.javarush.task.task27.task2712.ad.*;

public class DirectorTablet {
    private StatisticManager statisticManager = StatisticManager.getInstance();
    private StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

    public void printAdvertisementProfit() throws ParseException {
        /* List<EventDataRow> eventList =  statisticManager.getStorage().get(EventType.SELECTED_VIDEOS);
        long totalAmount = 0;
        for (EventDataRow event : eventList) {
            VideoSelectedEventDataRow eventVideoSelected = (VideoSelectedEventDataRow) event;
            totalAmount = totalAmount + eventVideoSelected.getAmount();
        } */
        TreeMap<Date, Long> amountPerDayMap = statisticManager.getAdProfitPerDay();
        double totalAmount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Date date : amountPerDayMap.descendingKeySet()) {
            double amountPerDayFloat = amountPerDayMap.get(date) / 100.00;
            ConsoleHelper.writeMessage(sdf.format(date) + " - " + amountPerDayFloat);
            totalAmount = totalAmount + amountPerDayFloat;
        }
        ConsoleHelper.writeMessage("Total - " + totalAmount);
    }

    public void printCookWorkloading() throws ParseException {
        TreeMap<String, TreeMap<String, Integer>> cookWorkloadingMap = statisticManager.getCookPerDayWorkloading();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (String date : cookWorkloadingMap.keySet()) {
            ConsoleHelper.writeMessage(date);
            TreeMap<String, Integer> cookMapPerDay = cookWorkloadingMap.get(date);
            for (String cookName : cookMapPerDay.keySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, (cookMapPerDay.get(cookName) + 59) / 60));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideosList = statisticAdvertisementManager.getAdsList(true);
        activeVideosList.sort(new Comparator<Advertisement>() {
            public int compare(Advertisement ad1, Advertisement ad2) {
                return ad1.getName().toLowerCase().compareTo(ad2.getName().toLowerCase());
            }
        });
        for (Advertisement ad : activeVideosList) {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> archivedVideosList = statisticAdvertisementManager.getAdsList(false);
        archivedVideosList.sort(new Comparator<Advertisement>() {
            public int compare(Advertisement ad1, Advertisement ad2) {
                return ad1.getName().toLowerCase().compareTo(ad2.getName().toLowerCase());
            }
        });
        for (Advertisement ad : archivedVideosList) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
