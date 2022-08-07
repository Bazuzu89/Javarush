package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File fileSource = new File(resultFileAbsolutePath);

        File fileDestination = new File(fileSource.getParent() + File.separator + "allFilesContent.txt");
        if (FileUtils.isExist(fileDestination)) {
            FileUtils.deleteFile(fileDestination);
        }
        FileUtils.renameFile(fileSource, fileDestination);
        File dir = new File(path);
        LinkedList<File> fileList = new LinkedList<>();
        fileList.addAll(Arrays.asList(dir.listFiles()));
        SortedMap<String, File> resultFilesList = new TreeMap();

        while (fileList.size() > 0) {                                       // находим все файлы <= 50 байт и добавляем в список
            File file = fileList.poll();
            if (file.isDirectory()) {
                fileList.addAll(Arrays.asList(file.listFiles()));
            } else if (file.isFile() && !file.getName().equals("allFilesContent.txt")) {
                if (file.length() <= 50) {
                    resultFilesList.put(file.getName(), file);
                }
            }
        }



        try (OutputStream outputStream = new FileOutputStream(fileDestination);
                BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(outputStream))) {                //записываем в результирующий файл данные из всех файлов
            for (String string : resultFilesList.keySet()) {
                File file = resultFilesList.get(string);
                InputStream inputStream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while (reader.ready()) {
                    fos.write(reader.readLine());
                }
                fos.newLine();
                reader.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
