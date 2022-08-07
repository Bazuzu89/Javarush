package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        LinkedList<File>  fileNamesQueue = new LinkedList<>();
        File directory = new File(root);
        fileNamesQueue.addAll(Arrays.asList(directory.listFiles()));
        while (fileNamesQueue.size() > 0) {
            File file = fileNamesQueue.poll();
            if (file.isDirectory()) {
                fileNamesQueue.addAll(Arrays.asList(file.listFiles()));
            } else if (file.isFile()) {
                fileTree.add(file.getAbsolutePath());
            }
        }
        return fileTree;

    }

    public static void main(String[] args) throws Exception {
        String root = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка";

        for (String fileName : getFileTree(root)) {
                System.out.println(fileName);
        }
    }
}
