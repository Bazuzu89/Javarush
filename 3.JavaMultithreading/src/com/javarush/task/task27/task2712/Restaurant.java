package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.*;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int  ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws ParseException {
        List<Tablet> tablets = new ArrayList<>();
        Cook dennisCook = new Cook("Dennis");
        dennisCook.setQueue(ORDER_QUEUE);
        Thread thread1 = new Thread(dennisCook);
        Cook antonCook = new Cook("Anton");
        antonCook.setQueue(ORDER_QUEUE);
        Thread thread2 = new Thread(antonCook);
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.setQueue(ORDER_QUEUE);
        }

        Waiter waiter1 = new Waiter();
        dennisCook.addObserver(waiter1);
        antonCook.addObserver(waiter1);
        StatisticManager statisticManager = StatisticManager.getInstance();
        RandomOrderGeneratorTask rogt = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread myThread = new Thread(rogt);
        myThread.start();
        try {
            Thread.sleep(1000);
            myThread.interrupt();
            myThread.join();
        } catch (InterruptedException ie) {
        }
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
