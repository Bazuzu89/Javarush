package com.javarush.task.pro.task08.task0812;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        //напишите тут ваш код
        int a = x;
        int b = y;
        a = b;
        y = x;
        x = a;


    }
}