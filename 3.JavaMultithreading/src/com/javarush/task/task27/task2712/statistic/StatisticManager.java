package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.*;

import java.text.SimpleDateFormat;
import java.util.*;
import com.javarush.task.task27.task2712.kitchen.*;
import java.util.concurrent.*;
import java.text.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();


    private StatisticManager() {}



    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    public StatisticStorage getStatisticStorage() {
        return statisticStorage;
    }
    public Map<EventType, List<EventDataRow>> getStorage() {
        return statisticStorage.storage;
    }

    public TreeMap<Date, Long> getAdProfitPerDay() throws ParseException {
        Map<Date, ArrayList<EventDataRow>> mapDate = getEventsPerDayMap(EventType.SELECTED_VIDEOS);
        TreeMap<Date, Long> resultMap = new TreeMap<>();
        for (Date date : mapDate.keySet()) {
            Long amountPerDay = 0l;
            for (EventDataRow event : mapDate.get(date)) {
                VideoSelectedEventDataRow eventVideoSelected = (VideoSelectedEventDataRow) event;
                amountPerDay = amountPerDay + eventVideoSelected.getAmount();
            }
            resultMap.put(date, amountPerDay);
        }
        return resultMap;
    }

    public TreeMap<String, TreeMap<String, Integer>> getCookPerDayWorkloading() throws ParseException {
        TreeMap<String, TreeMap<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<Date, ArrayList<EventDataRow>> mapDate = getEventsPerDayMap(EventType.COOKED_ORDER);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Date date : mapDate.keySet()) {
            TreeMap<String, Integer> dayCookMap = new TreeMap<>();
            for (EventDataRow event : mapDate.get(date)) {
                CookedOrderEventDataRow cookedOrderEvent = (CookedOrderEventDataRow) event;
                if (!dayCookMap.containsKey(cookedOrderEvent.getCookName())) {
                    dayCookMap.put(cookedOrderEvent.getCookName(), cookedOrderEvent.getTime());
                } else {
                    dayCookMap.put(cookedOrderEvent.getCookName(), dayCookMap.get(cookedOrderEvent.getCookName()) + cookedOrderEvent.getTime());
                }
            }
            resultMap.put(sdf.format(date), dayCookMap);
        }
        return resultMap;
    }

    private Map<Date, ArrayList<EventDataRow>> getEventsPerDayMap(EventType eventType) throws ParseException {
        Map<Date, ArrayList<EventDataRow>> mapDate = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow event : getStorage().get(eventType)) {
            String date = sdf.format(event.getDate());
            Date dateForMap  = sdf.parse(date);
            if (!mapDate.keySet().contains(dateForMap)) {
                mapDate.put(dateForMap, new ArrayList<>());
            }
        }
        for (EventDataRow event : getStorage().get(eventType)) {
            String date = sdf.format(event.getDate());
            Date dateForMap  = sdf.parse(date);
            mapDate.get(dateForMap).add(event);
        }
        return mapDate;
    }

    private Map<String, ArrayList<EventDataRow>> getOrdersPerCookMap(EventType eventType) {
        Map<String, ArrayList<EventDataRow>> mapCook = new TreeMap<>();
        for (EventDataRow event : getStorage().get(eventType)) {
            CookedOrderEventDataRow cookedOrderEvent = (CookedOrderEventDataRow) event;
            mapCook.put(cookedOrderEvent.getCookName(), new ArrayList<>());
        }
        for (EventDataRow event : getStorage().get(eventType)) {
            CookedOrderEventDataRow cookedOrderEvent = (CookedOrderEventDataRow) event;
            mapCook.get(cookedOrderEvent.getCookName()).add(event);
        }
        return mapCook;
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new TreeMap();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
