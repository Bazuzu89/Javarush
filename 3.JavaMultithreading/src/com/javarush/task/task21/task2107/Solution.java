package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.equals(clone.users));
            for (String key : solution.users.keySet()) {
                System.out.println(solution.users.get(key) == clone.users.get(key));
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    @Override
    public Solution clone() throws CloneNotSupportedException {
         Solution newSolution = (Solution) super.clone();
        newSolution.users = new LinkedHashMap<>();

        for (String string : this.users.keySet()) {
            String newKey = string;
            newSolution.users.put(newKey, (User) this.users.get(string).clone());
        }
        return newSolution;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User) || o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.hashCode() != o.hashCode()) {
            return false;
        }
        Solution solution = (Solution) o;
        if (this.users.equals(solution.users) && !(solution.users == null)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.users.hashCode();
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            // User newUser = new User(this.age, this.name);
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o.getClass() == getClass()) || o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (this.hashCode() != o.hashCode()) {
                return false;
            }
            User user = (User) o;
            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;

        }

        @Override
        public int hashCode() {
            return (this.name.hashCode()  + this.age) * 31;
        }
    }
}
