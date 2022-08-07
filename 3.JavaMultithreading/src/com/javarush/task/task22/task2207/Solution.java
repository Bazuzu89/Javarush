package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static List<Pair> getPairs(ArrayList<String> words) {

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) == null) {
                continue;
            }
            StringBuilder firstWord = new StringBuilder(words.get(i));
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j) == null) {
                    continue;
                }
                StringBuilder secondWord = new StringBuilder(words.get(j));
                String reversed = secondWord.reverse().toString();
                if (firstWord.toString().equals(reversed)) {
                    Pair pair = new Pair();
                    pair.first = firstWord.toString();
                    pair.second = secondWord.reverse().toString();
                    result.add(pair);
                    words.set(i, null);
                    words.set(j, null);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = fileNameReader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        // fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                sb.append(reader.readLine() + " ");
            }
            String[] line = sb.toString().split(" ");
            Collections.addAll(words, line);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (Pair pair : getPairs(words)) {
            System.out.println(pair.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
