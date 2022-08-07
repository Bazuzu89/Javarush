package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String s = scanner.nextLine();
            if (s.equals("user")) {
                person = new Person.User();
            }
             else if (s.equals("loser")) {
                person = new Person.Loser();
            }
            else if (s.equals("coder")) {
                person = new Person.Coder();
            }
            else if (s.equals("proger")) {
                person = new Person.Proger();
            }
            else break;
            doWork(person);
        }

            //создаем объект, пункт 2

             //вызываем doWork


    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            Person.User user = (Person.User) person;
            user.live();
        }
        if (person instanceof Person.Loser) {
            Person.Loser loser = (Person.Loser) person;
            loser.doNothing();
        }
        if (person instanceof Person.Coder) {
            Person.Coder coder = (Person.Coder) person;
            coder.writeCode();
        }
        if (person instanceof Person.Proger) {
            Person.Proger proger = (Person.Proger) person;
            proger.enjoy();
        }
    }
}
