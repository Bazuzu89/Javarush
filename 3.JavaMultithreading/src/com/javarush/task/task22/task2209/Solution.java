package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        //...
        String fileName = "";
        String line = "";
        /* try (BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = readerFileName.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt")))) {

                line = reader.readLine();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String[] stringArray = line.split(" ");
        StringBuilder result = getLine(stringArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null) {
            StringBuilder sb = new StringBuilder();
            return sb;
        }
        ArrayList<String> resultArray = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        String lastWord = null;
        for (int i = 0; i < words.length; i++) {
            boolean isLastMatch = false;
            boolean isFirstMatch = false;
            String lastLetterOfI = String.valueOf(words[i].charAt(words[i].length() - 1));
            String firstLetterOfI = String.valueOf(words[i].charAt(0));

            for (int j = i + 1; j < words.length; j++) {
                if (isLastMatch && isFirstMatch) {
                    continue;
                }
                String lastLetterOfJ = String.valueOf(words[j].charAt(words[j].length() - 1));
                String firstLetterOfJ = String.valueOf(words[j].charAt(0));
                if (lastLetterOfI.equalsIgnoreCase(firstLetterOfJ)) {
                    isLastMatch = true;
                }
                if (firstLetterOfI.equalsIgnoreCase(lastLetterOfJ)) {
                    isFirstMatch = true;
                }
            }
            if (!isLastMatch) {
                lastWord = words[i];
            }
            if (!isFirstMatch) {
                resultArray.add(0, words[i]);
            }
        }

        for (int i =  0; i < words.length; i++) {
            resultArray.clear();
            resultArray.add(words[i]);
            int j = 0;
            boolean isNextWordFound = true;
            while (resultArray.size() != words.length && isNextWordFound) {
                isNextWordFound = false;
                queue.addAll(Arrays.asList(words));
                queue.removeAll(resultArray);
                if (lastWord != null) {
                    queue.remove(lastWord);
                }
                while (!queue.isEmpty()) {
                    String lastLetter = String.valueOf(resultArray.get(j).charAt(resultArray.get(j).length() - 1));
                    String firstLetter = String.valueOf(queue.peek().charAt(0));
                    if (lastLetter.equalsIgnoreCase(firstLetter)) {
                        resultArray.add(queue.poll());
                        j++;
                        isNextWordFound = true;
                    } else {
                        queue.poll();
                    }
                }
            }
            if (resultArray.size() == words.length) {
                break;
            }
        }
        if (lastWord != null) {
            resultArray.add(lastWord);
        }

        if (resultArray.size() == words.length) {
        StringBuilder sb = new StringBuilder(String.join(" ", resultArray));
        return sb;
        }
        return new StringBuilder();
    }
}
