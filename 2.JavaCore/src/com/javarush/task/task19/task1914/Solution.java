package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        testString.printSomething();
        String[] array = baos.toString().split(" ");
        int equationResult = 0;
        switch (array[1]) {
            case "+" :
                equationResult = Integer.parseInt(array[0]) + Integer.parseInt(array[2]);
                break;
            case "-" :
                equationResult = Integer.parseInt(array[0]) - Integer.parseInt(array[2]);
                break;
            case "*" :
                equationResult = Integer.parseInt(array[0]) * Integer.parseInt(array[2]);
                break;
        }
        String string = "";
        for (int i = 0; i < array.length-1; i++) {
            string = string + " " + array[i];
        }
        String resultString = string + " " + String.valueOf(equationResult);
        System.setOut(console);
        System.out.println(resultString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

