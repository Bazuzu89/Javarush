package com.javarush.task.task28.task2805;

import java.lang.ThreadGroup;
import java.lang.Runnable;


public class MyThread extends Thread {

    private static int priority = 1;

    private void setPriority() {
        if (priority == 11) {
            priority = 1;
        }
        if (priority >= Thread.currentThread().getThreadGroup().getMaxPriority()) {
            setPriority(Thread.currentThread().getThreadGroup().getMaxPriority());
            priority++;
            return;
        }
        setPriority(priority);
        priority++;
    }

    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }


}
