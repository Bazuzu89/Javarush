package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        //напишите тут ваш код
        grades.put("Иван Иванов", 4.3);
        grades.put("Денис Денисвов", 4.3);
        grades.put("Денис Иванов", 4.3);
        grades.put("Иван Денисов", 4.3);
        grades.put("Иван Хер", 4.3);
    }
}
