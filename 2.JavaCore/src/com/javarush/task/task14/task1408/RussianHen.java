package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public static final String RUSSIA = "Russia";;
    public static final int COUNTOFEGGS = 500;
    @Override
    public String getDescription () {
        return super.getDescription() + " Моя страна - "+ RUSSIA+ ". Я несу "+ COUNTOFEGGS+" яиц в месяц.";
    }
    public int getCountOfEggsPerMonth () {
        return COUNTOFEGGS;
    }
}
