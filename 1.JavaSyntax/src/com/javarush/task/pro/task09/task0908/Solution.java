package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "10011101000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));

    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        String[] hexArray = new String[] {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
        String hex = "0123456789abcdef";
        String hexNumber = "";
        if (binaryNumber == null) {return "";}
        for (int i = 0; i < binaryNumber.length(); i++) {
            if ((binaryNumber.charAt(i) != '0') && (binaryNumber.charAt(i) != '1')) {
                return "";
            }
        }

        if (binaryNumber.length() % 4 > 0) {
                    for (int i = 0; i < binaryNumber.length() % 4; i++) {
                        binaryNumber = "0" + binaryNumber;
                    }
                }
                    for (int i = 0; i < binaryNumber.length(); i = i + 4) {
                        String quarter = binaryNumber.substring(i, i + 4);
                        for (int k = 0; k < hexArray.length; k++) {

                            if (quarter.equals(hexArray[k])) {
                                hexNumber = hexNumber + hex.charAt(k);
                            } else continue;
                        }

                    }

                return hexNumber;

        }


    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        String[] hexArray = new String[] {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
        String hex = "0123456789abcdef";
        String decimalNumber = "";
        if (hexNumber == null) {return "";}
        for (int i = 0; i < hexNumber.length(); i++) {
            for (int k = 0; k < hex.length(); k++ ) {
              if (hex.indexOf(hexNumber.charAt(i)) == -1) {return "";}
            }
            }

        for (int i = 0; i < hexNumber.length(); i++ ) {
            decimalNumber = decimalNumber + hexArray[hex.indexOf(hexNumber.charAt(i))];
        }
        return decimalNumber;
    }
}
