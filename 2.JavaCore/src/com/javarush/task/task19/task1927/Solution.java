package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        String contextAd = "JavaRush - курсы Java онлайн";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        testString.printSomething();
        String[] stringsArray = baos.toString().split("\\n");
        String resultString = "";

        for (int i = 0; i < stringsArray.length; i++) {
            if (!(i % 2 == 0)) {
                resultString = resultString + "\n" + stringsArray[i] + "\n" + contextAd;
            } else {
                resultString = resultString + "\n" + stringsArray[i];
            }
        }

        System.setOut(console);
        System.out.println(resultString);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
