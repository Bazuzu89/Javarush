package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            if (input.equals("sun")) {
                thePlanet = Sun.getInstance();
            }
            else if (input.equals("earth")) {
                thePlanet = Earth.getInstance();
            }

            else if (input.equals("moon")) {
                thePlanet = Moon.getInstance();
            }

            else thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // implement step #5 here - реализуйте задание №5 тут
    }
}
