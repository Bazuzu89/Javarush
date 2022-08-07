package com.javarush.task.task34.task3409;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


/* 
Настраиваем логгер
*/

public class Solution {
    public static void main(String args[]) throws IOException {
        String logProperties = "4.JavaCollections/src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
        }


        String append = "log4j.rootLogger = file, stdout\n"+
        "log4j.appender.file=org.apache.log4j.RollingFileAppender\n"+
        "log4j.appender.file.File=C:\\\\log\\runApp.log\n"+
        "log4j.appender.file.threshold=DEBUG\n"+
        "log4j.appender.file.MaxFileSize=5MB\n"+
        "log4j.appender.file.MaxBackupIndex=6\n"+

        "log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n"+
        "log4j.appender.stdout.threshold=ERROR\n"+
        "log4j.appender.stdout.Target=System.out\n";


    }
}
