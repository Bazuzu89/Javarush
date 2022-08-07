package com.javarush.task.task26.task2611;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int count = 1;
        try {
            while (true) {
                map.put(String.valueOf(count), String.format("Some text for %d", count));
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException ie) {
            System.out.println(String.format("[%S] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
