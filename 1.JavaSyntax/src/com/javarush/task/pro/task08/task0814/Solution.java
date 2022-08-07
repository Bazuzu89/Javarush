package com.javarush.task.pro.task08.task0814;

/* 
Флаги
*/

public class Solution {

    public static int setFlag(int number, int flagPos) {
        //напишите тут ваш код
        int result = number | (1 << flagPos);
        return result;
    }

    public static int resetFlag(int number, int flagPos) {
        //напишите тут ваш код
        int result = number & (~(1 << flagPos));
        return result;
    }

    public static boolean checkFlag(int number, int flagPos) {
        //напишите тут ваш код
        boolean result = (number & (1 << flagPos)) == (1 << flagPos);
        return result;
    }
}
