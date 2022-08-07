package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.*;
import java.util.*;
import java.io.*;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Выбери, чем ты набьешь свое брюхо, животное");
        String orderedDish;
        boolean isDishFoundInMenu = false;
        while (!(orderedDish = readString()).equalsIgnoreCase("exit")) {
            isDishFoundInMenu = false;
            for (Dish dish : Dish.values()) {
                if (dish.name().equalsIgnoreCase(orderedDish)) {
                    order.add(dish);
                    isDishFoundInMenu = true;
                    break;
                }
            }
            if (!isDishFoundInMenu) {
                writeMessage("Такого блюда нет в меню, чучело.");
            }
        }
        return order;
    }
}
