package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();

    }

    static class HenFactory implements Country {

        static Hen getHen(String country) {
            if (country.equals(UKRAINE)) {
                UkrainianHen hen = new UkrainianHen();
                return hen;
            }
            if (country.equals(BELARUS)) {
                BelarusianHen hen = new BelarusianHen();
                return hen;
            }
            if (country.equals(RUSSIA)) {
                RussianHen hen = new RussianHen();
                return hen;
            }
            if (country.equals(MOLDOVA)) {
                MoldovanHen hen = new MoldovanHen();
                return hen;
            }
            return null;
        }
    }


}
