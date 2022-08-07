package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Object();
        int x = (int) object;
    }

    public void methodThrowsNullPointerException() {
        String jopa = null;
        jopa.equals("жопа");
    }

    public static void main(String[] args) {

    }
}
