package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (getRomanDigitValue(s.charAt(i)) == -1) {
                return -1;
            } else {
                int digit = getRomanDigitValue(s.charAt(i));
                if ( i-1 >= 0 && digit == getRomanDigitValue(s.charAt(i-1))) {
                    if (i-2 >= 0 && digit == getRomanDigitValue(s.charAt(i-2))) {
                        digit = digit * 3;
                        i--;
                        i--;
                    } else {
                        digit = digit * 2;
                        i--;
                    }
                } else if (i-1 >= 0 && digit > getRomanDigitValue(s.charAt(i-1))) {
                    digit = digit - getRomanDigitValue(s.charAt(i-1));
                    i--;
                }
                result = result + digit;
            }
        }
        return result;
    }

    public static int getRomanDigitValue(char letter) {
        int digit;
        switch (letter) {
            case 'I' : digit = 1; break;
            case 'V' : digit = 5; break;
            case 'X' : digit = 10; break;
            case 'L' : digit = 50; break;
            case 'C' : digit = 100; break;
            case 'D' : digit = 500; break;
            case 'M' : digit = 1000; break;
            default : digit = -1;
        }
        return digit;
    }
}
