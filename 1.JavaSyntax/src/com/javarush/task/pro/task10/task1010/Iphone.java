package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/
class Donkey {
    private String name;

    public Donkey() {
        this.name = "Kolya";
    }
}
public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    //напишите тут ваш код
    public boolean equals (Object obj) {
        Iphone iphone = (Iphone) obj;
        if (iphone != null && this.model.equals(iphone.model) && this.color.equals(iphone.color) && this.price == iphone.price) {return true;}
        else {return false;}
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Donkey donkey = new Donkey();

        System.out.println(iphone1.equals(donkey));
    }

}
