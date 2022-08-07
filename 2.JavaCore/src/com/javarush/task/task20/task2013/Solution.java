package com.javarush.task.task20.task2013;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
            /* String isChildrenPresent = children.size() > 0 ? "yes" : "no";
            if (isChildrenPresent.equals("yes")) {
                out.writeChars(isChildrenPresent);
                for (Person person : children) {
                    out.writeObject(person);
                }
            } else {
                out.writeChars(isChildrenPresent);
            } */
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List) in.readObject();
            /* String isChildrenPresent = in.readLine();
            if (isChildrenPresent.equals("yes")) {
                while (in.available() > 0) {
                    Person person = (Person) in.readObject();
                    children.add(person);
                }
            } */
        }
    }

    public static void main(String[] args) {

    }
}
