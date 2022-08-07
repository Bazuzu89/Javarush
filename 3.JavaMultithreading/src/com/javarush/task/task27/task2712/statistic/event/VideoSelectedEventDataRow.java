package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.*;
import java.util.*;

public class VideoSelectedEventDataRow implements EventDataRow {
    private Date currentDate;
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }

    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    public long getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.currentDate;
    }

    public int getTime() {
        return this.totalDuration;
    }
}
