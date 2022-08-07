package com.javarush.task.task14.task1408;

public abstract class Hen {
    int countOfEggsPerMonth;
    String countryOfHen;
    String sampleDescription = " Моя страна - %s. Я несу %n яиц в месяц.";

    abstract int getCountOfEggsPerMonth();
    public String getDescription() {
        return "Я - курица.";
    }
}
