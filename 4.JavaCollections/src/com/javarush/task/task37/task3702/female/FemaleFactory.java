package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (age < 0) {
            System.out.println("Invalid age");
            return null;
        } else if (age < 13) {
            return new KidGirl();
        } else if (age < 20) {
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}
