package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // InputStream is = new ByteArrayInputStream(("C:\\Users\\SPG-NOTE\\Desktop\\Тестовая папка\\1Тест.txt").getBytes());
        // System.setIn(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();


               if (args[0].equals("-d")) {
                   ArrayList<String> newFileDelete = new ArrayList<>();
                   try (BufferedReader readerLine = new BufferedReader(new FileReader(fileName))) {
                       String s;
                       while (!((s = readerLine.readLine()) == null)) {                         // вычитываем все строки кроме удаленной из файла в изменяемый список
                           String ID = s.substring(0, 8).split(" ")[0];
                           if (!(Integer.parseInt(ID) == Integer.parseInt(args[1]))) {
                               newFileDelete.add(s);
                           }
                       }
                   }

                   try (BufferedWriter writerLine = new BufferedWriter(new FileWriter(fileName))) {
                       for (String string : newFileDelete) {                                   // записываем все строки кроме удаленной в файл
                           writerLine.write(string + "\n");
                       }
                   }
               }

               else if (args[0].equals("-u")) {
                   ArrayList<String> newFileUpdate = new ArrayList<>();
                   try (BufferedReader readerLine = new BufferedReader(new FileReader(fileName))) {
                       String s;
                       while (!((s = readerLine.readLine()) == null)) {                     // вычитываем все строки из файла в изменяемый список
                           String ID = s.substring(0, 8).split(" ")[0];
                           if (!(Integer.parseInt(ID) == Integer.parseInt(args[1]))) {
                               newFileUpdate.add(s);
                           } else {
                               String updatableID = args[1];
                               String productName = args[2];
                               String price = args[3];
                               String quantity = args[4];

                               for (int i = 0; i < 8 - args[1].length(); i++) {
                                   updatableID = updatableID + " ";
                               }

                               for (int i = 0; i < 30 - args[2].length(); i++) {
                                   productName = productName + " ";
                               }

                               for (int i = 0; i < 8 - args[3].length(); i++) {
                                   price = price + " ";
                               }

                               for (int i = 0; i < 4 - args[4].length(); i++) {
                                   quantity = quantity + " ";
                               }

                               String updatedLine = updatableID + productName + price + quantity;
                               newFileUpdate.add(updatedLine);
                           }
                       }
                   }

                   try (BufferedWriter writerLine = new BufferedWriter(new FileWriter(fileName))) {

                       for (String string : newFileUpdate) {                    // записываем все данные в файл
                           writerLine.write(string + "\n");
                       }

                   }
               }

    }
}
