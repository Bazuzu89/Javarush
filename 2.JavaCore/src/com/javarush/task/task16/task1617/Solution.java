package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        try {Thread.sleep(3500);} catch (InterruptedException e) {}
        clock.interrupt();


        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут

            while (numSeconds > 0) {
                count++;
                System.out.println(numSeconds);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Прервано!");
                    break;
                }
                numSeconds--;
            }
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("Марш!");

            }
        }
    }
}
