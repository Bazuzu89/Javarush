package com.javarush.task.task20.task2022;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\Тест1.txt";
        Solution solution = new Solution(fileName);
        String testString = "testString";
        try {
        solution.writeObject(testString);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream out = new ObjectOutputStream(fileOutput);
        FileInputStream fileInput = new FileInputStream("your.file.name");
        ObjectInputStream in = new ObjectInputStream(fileInput);
        out.writeObject(solution);
        Solution newSolution = (Solution) in.readObject();
        newSolution.writeObject("православныйТестСтринг");
        System.out.println(newSolution.toString());
    }
}
