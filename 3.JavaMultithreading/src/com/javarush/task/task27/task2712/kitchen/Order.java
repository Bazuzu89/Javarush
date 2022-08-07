package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;
import java.util.*;
import com.javarush.task.task27.task2712.*;
import java.io.*;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        String orderString = "";
        if (!(dishes.size() == 0)) {
            orderString = String.format("Your order: %s of %s, cooking time %dmin", dishes, tablet.toString(), getTotalCookingTime());
        }
        return orderString;
    }

    public int getTotalCookingTime() {
        int totalCookingTime = 0;
        for (Dish dish : dishes) {
            totalCookingTime = totalCookingTime + dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    protected void initDishes() throws IOException{
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return this.tablet;
    }
}
