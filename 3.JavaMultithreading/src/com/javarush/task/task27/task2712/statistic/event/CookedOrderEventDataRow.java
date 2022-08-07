package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;

public class CookedOrderEventDataRow implements EventDataRow {
    private Date currentDate;
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishes;
    // private static int dateCounter = 11;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) throws ParseException {
        /* SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        currentDate = sdf.parse(dateCounter++ + "-May-2022");
        if (dateCounter >= 13) {
            dateCounter = 11;
        } */
        currentDate = new Date();
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
    }

    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    public Date getDate() {
        return this.currentDate;
    }

    public int getTime() {
        return this.cookingTimeSeconds;
    }

    public String getCookName() {
        return this.cookName;
    }
}
