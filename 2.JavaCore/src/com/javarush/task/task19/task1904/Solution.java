package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        public Person read() {
            String personData = this.fileScanner.nextLine();
            String[] personDataArray = personData.split(" ");
            String firstName = personDataArray[1];
            String middleName = personDataArray[2];
            String lastName = personDataArray[0];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(personDataArray[5]), Integer.parseInt(personDataArray[4]) - 1, Integer.parseInt(personDataArray[3]));
            Date birthDate = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthDate);
        }

        public void close() {
            this.fileScanner.close();
        }
    }
}
