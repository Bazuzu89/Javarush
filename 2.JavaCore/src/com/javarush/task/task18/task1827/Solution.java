package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        if (!(args[0].equals("-c") && args.length == 4)) return;
        // String input = "C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\1Тест.txt";
        // InputStream is = new ByteArrayInputStream(input.getBytes());
        // System.setIn(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxID = 0;
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader lineReader = new BufferedReader(fileReader)) {
            String s = null;

            while (!((s = lineReader.readLine()) == null)) {
                 char[] charArray = s.toCharArray();
                 String ID = "";
                 for (int i = 0; i < 8; i++) {
                     if (!(charArray[i] == ' '))
                     ID = ID + charArray[i];
                 }
                 if (Integer.parseInt(ID) > maxID) {
                     maxID = Integer.parseInt(ID);
                 }
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true))
            {
            if (maxID == 99999999) System.out.println("База данных переполнена");
            int newIntID = maxID+1;                                             // генерируем новый ID
            String newIntIDString = String.valueOf(newIntID);
            int charNumberID = newIntIDString.length();
            for (int i = 0; i < 8 - charNumberID; i++) {
                newIntIDString = newIntIDString + " ";
            }

            String name = args[1];                                                               //генерируем новое наимнование
            int charNumberName = name.length();
            for (int i = 0; i < 30 - charNumberName; i++) {
                name = name + " ";
            }
            String price = args[2];                                                               //генерируем новое наимнование
            int charNumberPrice = price.length();
            for (int i = 0; i < 8 - charNumberPrice; i++) {
                 price = price + " ";
            }
            String quantity = args[3];                                                               //генерируем новое наимнование
            int charNumberQuantity = quantity.length();
            for (int i = 0; i < 4 - charNumberQuantity; i++) {
                 quantity = quantity + " ";
            }



            String newLine = newIntIDString + name + price + quantity;
            fileWriter.write('\n' + newLine);
        }




    }
}
