package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
                while (fileReader.ready()) {
                    String[] stringArray = fileReader.readLine().split(" ");
                    String name = "";
                    for (int i = 0; i < stringArray.length - 3; i++) {
                        name += (stringArray[i] + " ");
                    }
                    String newName = name.trim();
                    int year = Integer.parseInt(stringArray[stringArray.length - 1]);
                    int month = Integer.parseInt(stringArray[stringArray.length - 2]) - 1;
                    int day = Integer.parseInt(stringArray[stringArray.length - 3]);
                    Calendar calendar = new GregorianCalendar(year, month, day);
                    Date birthDate = calendar.getTime();
                    PEOPLE.add(new Person(newName, birthDate));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            for (Person person : PEOPLE) {
                System.out.println(person.getName());
                System.out.println(person.getBirthDate());
            }
    }
}
