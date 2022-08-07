package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if (args[0].equals("-c") && args.length == 4) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = String.valueOf(args[3]);
            if (args[2].equals("м")) {
                try {
                    allPeople.add(Person.createMale(args[1], dateFormat.parse(date)));
                } catch (ParseException pe) {
                    pe.printStackTrace();
                    System.out.println("Неправильный формат даты");
                }
            } else if (args[2].equals("ж")) {
                try {
                    allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])) );
                } catch (ParseException pe) {
                    System.out.println("Неправильный формат даты");
                }
            }
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-r") && args.length == 2) {
                System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " ");
                Sex sex = allPeople.get(Integer.parseInt(args[1])).getSex();
                if (sex.equals(Sex.MALE)) {
                    System.out.print("м ");
                } else if (sex.equals(Sex.FEMALE)) {
                    System.out.print("ж ");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
                System.out.println(sdf.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));

        } else if (args[0].equals("-u") && args.length == 5) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("м") || args[3].equals("ж")) {
                Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                    allPeople.get(Integer.parseInt(args[1])).setSex(sex);
                } else {System.out.println("Неправильный формат пола");}
                try {
                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(dateFormat.parse(String.valueOf(args[4])));
                } catch (ParseException pe) {
                    System.out.println("Неправильный формат даты");
                }
        } else if (args[0].equals("-d") && args.length == 2) {
                // allPeople.remove(Integer.parseInt(args[1]));
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }

        }
    }

