package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> treeSet =  createTreeSetOfLetters(args[0]);
        printOutFiveElementsOfSet(treeSet);
    }

    public static TreeSet<Character> createTreeSetOfLetters(String fileName) {
        TreeSet<Character> result = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String stringFromFile = "";
            while (reader.ready()) {
                stringFromFile += reader.readLine();
            }
            for (int i = 0; i < stringFromFile.length(); i++) {
                char charI = stringFromFile.charAt(i);
                if (Character.isAlphabetic(charI)) {
                    result.add(charI);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    public static void printOutFiveElementsOfSet(TreeSet<Character> set) {
        int i = 0;
        for (Character character : set) {
            System.out.print(character);
            i++;
            if (i == 5) {
                break;
            }
        }
    }
}
