package com.javarush.task.task25.task2512;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        LinkedList<Throwable> list = new LinkedList<>();
        while (e != null) {
            list.add(e);
            e = e.getCause();
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            Throwable thr = list.get(i);
            System.out.println(thr.getClass().getName() + ": " + thr.getMessage());
        }

    }


    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
