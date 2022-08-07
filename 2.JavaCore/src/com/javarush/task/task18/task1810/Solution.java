package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

             ) {

            int count = 1001;
            while (true) {
                FileInputStream fis = new FileInputStream(reader.readLine());
                count = fis.available();
                fis.close();
                if (count < 1000) {
                    throw new DownloadException();

                }
            }




        } catch (IOException e) {

        }

    }

    public static class DownloadException extends Exception {

    }
}
