package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        try {
            Path path = Paths.get(pathToFile);
            Boolean hidden = Files.isHidden(path);
            Boolean executable = Files.isExecutable(path);
            Boolean directory = Files.isDirectory(path);
            Boolean writable = Files.isWritable(path);
            fileData = new ConcreteFileData(hidden,executable, directory, writable);
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
