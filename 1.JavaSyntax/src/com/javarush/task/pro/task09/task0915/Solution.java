package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);


        String[] tokens = new String[6];
        for (int i = 0; i < 6; i++)
        {
                if (tokenizer.hasMoreTokens()) {
                    tokens[i] = tokenizer.nextToken();
                }
                else tokens[i] = null;
        }
        return tokens;
    }
}
