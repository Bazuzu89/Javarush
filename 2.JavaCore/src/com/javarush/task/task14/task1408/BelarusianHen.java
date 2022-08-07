package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public static final String BELARUS = "Belarus";
    public static final int COUNTOFEGGS = 15;

    @Override
    public String getDescription () {
        return super.getDescription() + " Моя страна - "+ BELARUS+ ". Я несу "+ COUNTOFEGGS+" яиц в месяц.";
    }
    public int getCountOfEggsPerMonth () {
      return COUNTOFEGGS;
    }
}
