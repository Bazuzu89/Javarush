package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.file.Paths;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static
    {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        firstFileName = reader.readLine();
        secondFileName = reader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileContent = "";
        private String fileName;
        public void setFileName(String fullFileName) {
                fileName = fullFileName;
        }



        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
                while (reader.ready()) {
                    fileContent += reader.readLine() + " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getFileContent() {
            return this.fileContent;
        }
        }



}
