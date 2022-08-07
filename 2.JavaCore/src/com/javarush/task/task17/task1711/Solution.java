package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    int quantityOfPeople = (args.length - 1) / 3;
                    for (int i = 0; i < quantityOfPeople * 3; i = i + 3) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String date = String.valueOf(args[3 + i]);
                        if (args[2 + i].equals("м")) {
                            try {
                                allPeople.add(Person.createMale(args[1 + i], dateFormat.parse(date)));
                            } catch (ParseException pe) {
                                pe.printStackTrace();
                                System.out.println("Неправильный формат даты");
                            }
                        } else if (args[2 + i].equals("ж")) {
                            try {
                                allPeople.add(Person.createFemale(args[1 + i], dateFormat.parse(args[3 + i])));
                            } catch (ParseException pe) {
                                System.out.println("Неправильный формат даты");
                            }
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u" :
                synchronized (allPeople) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    int quantityOfPeople = (args.length - 1) / 4;
                    for (int i = 0; i < quantityOfPeople * 4; i = i + 4) {
                        allPeople.get(Integer.parseInt(args[1 + i])).setName(args[2 + i]);
                        if (args[3 + i].equals("м") || args[3 + i].equals("ж")) {
                            Sex sex = args[3 + i].equals("м") ? Sex.MALE : Sex.FEMALE;
                            allPeople.get(Integer.parseInt(args[1 + i])).setSex(sex);
                        } else {
                            System.out.println("Неправильный формат пола");
                        }
                        try {
                            allPeople.get(Integer.parseInt(args[1 + i])).setBirthDate(dateFormat.parse(String.valueOf(args[4 + i])));
                        } catch (ParseException pe) {
                            System.out.println("Неправильный формат даты");
                        }
                    }
                }
                break;
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        allPeople.get(Integer.parseInt(args[i + 1])).setName(null);
                        allPeople.get(Integer.parseInt(args[i + 1])).setBirthDate(null);
                        allPeople.get(Integer.parseInt(args[i + 1])).setSex(null);
                    }
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        System.out.print(allPeople.get(Integer.parseInt(args[i+1])).getName() + " ");
                        if (allPeople.get(Integer.parseInt(args[i+1])).getSex().equals(Sex.MALE)) {
                            System.out.print("м ");
                        } else if (allPeople.get(Integer.parseInt(args[i+1])).getSex().equals(Sex.FEMALE)) {
                            System.out.print("ж ");
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.print(sdf.format(allPeople.get(Integer.parseInt(args[i+1])).getBirthDate()));
                        System.out.println();
                    }
                }
                break;
        }

    }
}
