package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    public static final String UKRAINE = "Ukraine";
    public static final int COUNTOFEGGS = 13;
    @Override
    public String getDescription () {
        return super.getDescription() + " Моя страна - "+ UKRAINE+ ". Я несу "+ COUNTOFEGGS+" яиц в месяц.";
    }
    public int getCountOfEggsPerMonth () {
        return COUNTOFEGGS;
    }
}
