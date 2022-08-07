package com.javarush.task.task30.task3010;

import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {int radix = 0;
        for (int i = 0; i < args[0].length(); i++) {
            char thisChar = args[0].charAt(i);
            if (!(( thisChar < 58 && thisChar > 47) || (thisChar > 64 && thisChar < 91) || (thisChar > 96 && thisChar < 123))) {
                radix = -1;
                break;
            } else {
                if (thisChar < 58 && thisChar > 47 ) {
                    if (thisChar - 47 > radix) {radix = thisChar - 47;}
                }
                if (thisChar > 64 && thisChar < 91) {
                    if (thisChar - 54 > radix) {radix = thisChar - 54;}
                }
                if (thisChar > 96 && thisChar < 123) {
                    if (thisChar - 86 > radix) {radix = thisChar - 86;}
                }
            }
        }
         if (radix == -1) {
             System.out.println("incorrect");
        } else if (radix < 2) {
             System.out.println(2);
         } else
        System.out.println(radix);
    } catch (Exception e) {
        }
    }
}