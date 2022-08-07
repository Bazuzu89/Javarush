package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        } try {
            Exception e = new Exception();
            throw e;
        }
        catch (Exception e) {
            exceptions.add(e);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("хуита"));


        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            String s = null;
            Object o = Integer.valueOf(s);
        }
        catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            int[] array = new int[5];
            array[6] = 7;
        }  catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        } try {
            int[] array = new int[-5];
            array[6] = 7;
        }
        catch (NegativeArraySizeException e) {
            exceptions.add(e);
        } try {
            String s = null;
            if (s.equals("хуй")) {
                System.out.println("тебе хуй");
            };
        }
        catch (NullPointerException e) {
            exceptions.add(e);
        } try {
            Object o = Integer.valueOf(42);
            String s = (String) o;
        }
        catch (ClassCastException e) {
            exceptions.add(e);
        } try {
            NoSuchElementException e = new NoSuchElementException();
            throw e;
        } catch (NoSuchElementException e) {
            exceptions.add(e);
        }
        try {
            RuntimeException e = new RuntimeException();
            throw e;
        } catch (RuntimeException e) {
            exceptions.add(e);
        }


        //напишите тут ваш код

    }
}
