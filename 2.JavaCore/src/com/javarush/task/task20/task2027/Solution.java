package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> foundWords = new ArrayList<>();
        for (String word : words) {
            Word foundWord = new Word(word);
            boolean isWordFound = false;
            char[] charArray = word.toCharArray();

            for (int j = 0; j < crossword.length; j++) {        // поиск первой буквы
                for (int k = 0; k < crossword[j].length; k++) {
                    if (crossword[j][k] == charArray[0]) {
                         isWordFound = true;
                        foundWord.setStartPoint(j, k);
                        break;
                        }
                    }
                }
            if (isWordFound) {

                    if (charArray[1] == crossword[foundWord.startX - 1][foundWord.startY - 1]) {
                        for (int i = 2; i < charArray.length; i++) {
                            if (crossword[foundWord.startX - i][foundWord.startY - i] == charArray[charArray.length - 1]) {
                                foundWord.setEndPoint(foundWord.startX - i, foundWord.startY - i);
                            }
                        }
                        if (!(charArray[1] == crossword[foundWord.startX - 1][foundWord.startY - 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX][foundWord.startY - 1]) {
                        if (!(charArray[1] == crossword[foundWord.startX][foundWord.startY - 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX + 1][foundWord.startY - 1]) {
                        if (!(charArray[1] == crossword[foundWord.startX + 1][foundWord.startY - 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX + 1][foundWord.startY]) {
                        if (!(charArray[1] == crossword[foundWord.startX + 1][foundWord.startY])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX + 1][foundWord.startY + 1]) {
                        if (!(charArray[1] == crossword[foundWord.startX + 1][foundWord.startY + 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX][foundWord.startY + 1]) {
                        if (!(charArray[1] == crossword[foundWord.startX][foundWord.startY + 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX - 1][foundWord.startY + 1]) {
                        if (!(charArray[1] == crossword[foundWord.startX - 1][foundWord.startY + 1])) {
                            break;
                        }
                    } else if (charArray[1] == crossword[foundWord.startX - 1][foundWord.startY]) {
                        if (!(charArray[1] == crossword[foundWord.startX - 1][foundWord.startY])) {
                            break;
                        }
                    }

                if (i == charArray.length - 1) {
                        foundWord.setEndPoint(i, i);
                    }

            }
        }

        return null;
    }




    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
