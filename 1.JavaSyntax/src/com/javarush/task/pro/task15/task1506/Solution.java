package com.javarush.task.pro.task15.task1506;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код


        myMethod();
    }

    public static void myMethod() {
        try (Scanner scanner = new Scanner(System.in);
        ) {
            List<String> buffer = Files.readAllLines(Paths.get(scanner.nextLine()));
            buffer.forEach(str -> {
                char[] chars = str.toCharArray();
                for (char character : chars) {
                    if (character != ' ' && character != ',' && character != '.') {
                        System.out.print(character);
                    }
                }
            });

        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

