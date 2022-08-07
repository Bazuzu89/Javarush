package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        ArrayList<Integer> list = new ArrayList(Arrays.asList(array));
        Collections.sort(list);
        int mediana;
        if (list.size() % 2 == 0) {
            mediana = (list.get(list.size() / 2 ) + list.get(list.size() / 2 - 1))/2;
        } else {
            mediana = list.get((list.size() - 1) / 2 );
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return Math.abs(int1 - mediana) - Math.abs(int2 - mediana);
            }
        });
        Integer[] resultArray = new Integer[list.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }
}
