package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        //напишите тут ваш код
        Path path1 = Path.of(str1);
        Path path2 = Path.of(str2);
        try {
            Path relPath = path1.relativize(path2);
            System.out.println(relPath);
        } catch (Exception e) {
            System.out.println(path2.relativize(path1));
        }
    }
}

