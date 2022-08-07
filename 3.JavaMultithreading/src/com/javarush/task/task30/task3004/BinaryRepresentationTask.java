package com.javarush.task.task30.task3004;

import java.util.concurrent.*;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            result = task.join() + result;
        }
        return result;
    }

}
