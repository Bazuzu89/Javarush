package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (!(n instanceof Solution) || n == null) {
            return false;
        }
        if (this == n) {
            return true;
        }
        if (this.hashCode() != n.hashCode()) {
            return false;
        }
        Solution o = (Solution) n;
        return Objects.equals(first, o.first) && Objects.equals(last, o.last);
    }

    public int hashCode() {

        return (first + last).hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
