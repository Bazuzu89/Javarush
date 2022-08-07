package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private int dirQuantity = -1;
    private int fileQuantity = 0;
    private int generalLength = 0;

    public int getDirQuantity() {
        return dirQuantity;
    }

    public int getFileQuantity() {
        return fileQuantity;
    }

    public int getGeneralLength() {
        return generalLength;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            fileQuantity++;
            byte[] content = Files.readAllBytes(file);
            generalLength += content.length;
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        dirQuantity++;
        return super.postVisitDirectory(dir, exc);
    }
}
