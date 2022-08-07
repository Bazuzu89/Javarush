package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    static {
        labels.put(54d, "Zhopa");
        labels.put(108d, "a");
        labels.put(216d, "pa");
        labels.put(512d, "opa");
        labels.put(1024d, "hopa");
    }
}
