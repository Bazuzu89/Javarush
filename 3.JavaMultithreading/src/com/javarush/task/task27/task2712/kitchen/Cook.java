package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import com.javarush.task.task27.task2712.*;
import com.javarush.task.task27.task2712.statistic.*;
import com.javarush.task.task27.task2712.statistic.event.*;
import java.text.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                if (!queue.isEmpty() && !isBusy()) {
                    startCookingOrder(queue.poll());
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void startCookingOrder(Order order)  {
        busy = true;
        try {
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        setChanged();
        notifyObservers(order);
        EventDataRow data = new CookedOrderEventDataRow(order.getTablet().toString(), this.toString(), order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(data);
        Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (ParseException pe) {
            pe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        busy = false;
    }
}
