package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {
    private static volatile AtomicInteger a = new AtomicInteger(0);
    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private volatile int a = 0;
        private volatile AtomicInteger b = new AtomicInteger(1);

        public AmigoThreadFactory() {
            a = Solution.a.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {

            String groupName = Thread.currentThread().getThreadGroup().getName();
            String name = String.format("%s-pool-%d-thread-%d", groupName, a, b.intValue());
            Thread thread = new Thread(r, name);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            b.incrementAndGet();
            return thread;
        }
    }
}
