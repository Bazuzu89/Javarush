package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        String[] fileNameArray = urlString.split("/");
        String fileName = fileNameArray[fileNameArray.length - 1].split("\\.")[0];
        Path tempFile = Files.createTempFile(fileName, ".txt");
        Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path resultFile = Paths.get(downloadDirectory + "/" + fileName + ".txt");
        Files.move(tempFile, resultFile, StandardCopyOption.REPLACE_EXISTING);
        return resultFile;
    }
}
