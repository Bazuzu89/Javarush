package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    public static final int CARSCOUNT = 5000;
    @Override
    public int getCarsCount() {
        return CARSCOUNT;
    }
}
