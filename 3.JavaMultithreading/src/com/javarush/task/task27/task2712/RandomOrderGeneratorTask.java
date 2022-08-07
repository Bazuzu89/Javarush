package com.javarush.task.task27.task2712;

import java.util.*;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletsList;
    private int orderCreatingInterval;

    public void run() {
        try {
            while(true) {
                int tabletIndex = (int) (Math.random() * tabletsList.size());
                tabletsList.get(tabletIndex).createTestOrder();
                Thread.sleep(orderCreatingInterval);
            }
        } catch (InterruptedException ie) {
        }
    }

    public RandomOrderGeneratorTask(List<Tablet> tabletsList, int orderCreatingInterval) {
        this.tabletsList = tabletsList;
        this.orderCreatingInterval = orderCreatingInterval;
    }
}
