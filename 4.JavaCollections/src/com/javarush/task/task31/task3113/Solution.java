package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path directory;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            directory = Paths.get(reader.readLine());
            if (!Files.isDirectory(directory)) {
                System.out.println(directory.toAbsolutePath() + " - не папка");
                return;
            }

            SearchFileVisitor sfv = new SearchFileVisitor();
            Files.walkFileTree(directory, sfv);
            System.out.println("Всего папок - " + sfv.getDirQuantity());
            System.out.println("Всего файлов - " + sfv.getFileQuantity());
            System.out.println("Общий размер - " + sfv.getGeneralLength());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
