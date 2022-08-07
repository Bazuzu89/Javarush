package com.javarush.task.task27.task2712;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.*;
import java.io.*;
import com.javarush.task.task27.task2712.kitchen.*;
import com.javarush.task.task27.task2712.ad.*;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            notifyAndProcess(order);
        } catch(IOException ioe) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return order;
        } catch (NoVideoAvailableException nvae) {
            logger.log(Level.INFO, String.format("No video is available for the order %s", order));
        }
        return order;
    }

    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            notifyAndProcess(order);
        } catch(IOException ioe) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException nvae) {
            logger.log(Level.INFO, String.format("No video is available for the order %s", order));
        }
    }

    private void notifyAndProcess(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        if (!order.isEmpty()) {
            queue.add(order);
            AdvertisementManager adManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            adManager.processVideos();
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
