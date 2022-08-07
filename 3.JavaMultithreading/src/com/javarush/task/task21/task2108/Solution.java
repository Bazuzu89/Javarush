package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

        System.out.println(Arrays.toString(tree.branches));
        System.out.println(Arrays.toString(clone.branches));
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() throws CloneNotSupportedException {
            Tree newTree = (Tree) super.clone();
            newTree.branches = new String[this.branches.length];
            for (int i = 0; i < branches.length; i++) {
                String newBranch = this.branches[i];
                newTree.branches[i] = newBranch;
            }
            return newTree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Tree) || o == null || o.hashCode() != this.hashCode() ) {
                return false;
            }
            Tree tree = (Tree) o;
             if (!this.getName().equals(tree.getName()))
                 return false;
            if (!Arrays.equals(this.branches, tree.branches))
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            return 31 * branches.hashCode();
        }
    }
}
