package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    public Thread thread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException ie) {
                break;
            }
        }
    }

    public void start(String threadName) {
        
        thread = new Thread(this, threadName);
        thread.start();
    }

    public void start() {};

    public void stop() {
        thread.interrupt();
    }
}
