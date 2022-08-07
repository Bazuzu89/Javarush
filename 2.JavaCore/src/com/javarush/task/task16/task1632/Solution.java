package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
    }

    public static class ThreadOne extends Thread {
        public void run() {
            while (true) {
            }
        }
    }

    public static class ThreadTwo extends Thread {
        public void run() {
            try {if (Thread.currentThread().isInterrupted()) {
                InterruptedException e = new InterruptedException();
                throw e;
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThree extends Thread {
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.currentThread().sleep(500);

                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class ThreadFour extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {}
        }
        public void showWarning() {

                this.interrupt();

        }
    }

    public static class ThreadFive extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int sum = 0;
            try {
                while (!(s = reader.readLine()).equals("N")) {
                    sum = sum + Integer.valueOf(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}
