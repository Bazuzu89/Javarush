package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) {
        try
         {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String file1Name = bufferedReader.readLine();
            String file2Name = bufferedReader.readLine();
            FileReader file1Reader = new FileReader(file1Name);
            FileReader file2Reader = new FileReader(file2Name);
            BufferedReader file1BufferedReader = new BufferedReader(file1Reader);
            for (Object object : file1BufferedReader.lines().toArray()) {
                allLines.add(String.valueOf(object));
            }
            BufferedReader file2BufferedReader = new BufferedReader(file2Reader);
            for (Object object : file2BufferedReader.lines().toArray()) {
                forRemoveLines.add(String.valueOf(object));
            }
            bufferedReader.close();
            file1Reader.close();
            file2Reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException {
        boolean nonCorrupted = true;
        for (String lineFromRL : forRemoveLines) {
                int index = allLines.indexOf(lineFromRL);
                if (index == -1) {
                    nonCorrupted = false;
                    break;
                }
            }
        if (nonCorrupted) {
            for (String line : forRemoveLines) {
                allLines.remove(line);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
