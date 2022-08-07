package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Movable, Sellable, Discountable {
        public boolean isMovable() {
            return true;
        }
        public String getAllowedAction(String name) {
            return "Sell";
        }
        public String getAllowedAction() {
            return "Discount";
        }

    }
}
