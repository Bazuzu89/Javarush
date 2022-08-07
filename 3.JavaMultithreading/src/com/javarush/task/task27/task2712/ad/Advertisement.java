package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;
    private long amountPerSecond;
    private boolean isActive;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits != 0) {
            amountPerOneDisplaying = initialAmount / hits;
            amountPerSecond = 1000 * amountPerOneDisplaying / this.duration;
        }
    }

    public boolean isActive() {
        return hits > 0;
    }

    public long getAmountPerSecond() {
        return this.amountPerSecond;
    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    public long getAmountPerOneDisplaying() {
        return this.amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }
    public int getHits() {
        return this.hits;
    }

    @Override
    public String toString() {
        return getName() + " " + getDuration();
    }
}
