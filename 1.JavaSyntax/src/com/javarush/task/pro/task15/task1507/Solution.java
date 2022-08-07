package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        changeLines();
    }

    public static void changeLines() {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> input = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (String line : input) {
                if(input.indexOf(line) % 2 == 0) {
                    System.out.println(line);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Some thing went wrong");
        }
    }
}

