package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        //напишите тут ваш код
        Random numberBall = new Random();
        int x = numberBall.nextInt(8);
        if (x > 7) { return null;}
        else
        if (x == 0) {return ("Бесспорно");}
        if (x == 1) {return ("Определённо да");}
        if (x == 2) {return ("Вероятнее всего");}
        if (x == 3) {return ("Хорошие перспективы");}
        if (x == 4) {return ("Спроси позже");}
        if (x == 5) {return ("Попробуй снова");}
        if (x == 6) {return ("Мой ответ — нет");}
        if (x == 7) {return ("Весьма сомнительно");}
        return null;
    }
}
