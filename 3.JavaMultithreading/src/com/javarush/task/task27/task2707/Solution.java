package com.javarush.task.task27.task2707;

import java.lang.Thread.State;

/* 
Определяем порядок захвата монитора
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        boolean isBlocked = false;
        Thread thread1 = new Thread() {
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    synchronized(o2) {

                    }

                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        if (thread2.getState() != State.BLOCKED) {
            return true;
        } else {return false;}
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
