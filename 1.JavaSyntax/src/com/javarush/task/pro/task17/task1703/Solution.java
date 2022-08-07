package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Космическая одиссея ч.1
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        //напишите тут ваш код
        Astronaut human1 = new Human();
        Astronaut human2 = new Human();
        Astronaut cat = new Cat();
        Astronaut dog = new Dog();
        astronauts.add(human1);
        astronauts.add(human2);
        astronauts.add(cat);
        astronauts.add(dog);

    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
