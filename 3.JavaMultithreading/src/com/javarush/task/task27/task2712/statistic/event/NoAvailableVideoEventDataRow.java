package com.javarush.task.task27.task2712.statistic.event;

import java.util.*;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    private Date currentDate;
    private int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        currentDate = new Date();
        this.totalDuration = totalDuration;
    }

    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    public Date getDate() {
        return this.currentDate;
    }

    public int getTime() {
        return this.totalDuration;
    }
}
