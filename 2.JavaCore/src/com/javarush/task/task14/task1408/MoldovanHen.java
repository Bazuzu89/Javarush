package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    public static final String MOLDOVA = "Moldova";
    public static final int COUNTOFEGGS = 10;
    @Override
    public String getDescription () {
        return super.getDescription() + " Моя страна - "+ MOLDOVA+ ". Я несу "+ COUNTOFEGGS+" яиц в месяц.";
    }
    public int getCountOfEggsPerMonth () {
        return COUNTOFEGGS;
    }
}
