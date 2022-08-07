package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.*;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    public void initDishes() throws IOException {
        dishes = new ArrayList<>();
        int quantityOfDishes = (int) (Math.random() * 3 + 2);
        for (int i = 0; i < quantityOfDishes; i++) {
            dishes.add(Dish.values()[(int) (Math.random() * Dish.values().length)]);
        }
    }

}
