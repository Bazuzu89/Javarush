package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    ArrayList<Entry> entryList;

    public CustomTree() {
        this.root = new Entry("root");
        this.entryList = new ArrayList<>();
        entryList.add(root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }




    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;



        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }

    public boolean add(String elementName) {
        LinkedList<Entry> queue = new LinkedList<Entry>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            if (queue.peek().availableToAddRightChildren) {
                if (queue.peek().availableToAddLeftChildren) {
                    Entry newEntry = new Entry(elementName);
                    newEntry.parent = queue.peek();
                    queue.peek().availableToAddLeftChildren = false;
                    queue.poll().leftChild = newEntry;
                    entryList.add(newEntry);
                    queue.clear();
                } else {
                    Entry newEntry = new Entry(elementName);
                    newEntry.parent = queue.peek();
                    queue.peek().availableToAddRightChildren = false;
                    entryList.add(queue.poll().rightChild = newEntry);
                    queue.clear();
                }
            } else {
                Entry entry = queue.poll();
                if (!(entry.leftChild == null)) {
                    queue.add(entry.leftChild);
                }
                if (!(entry.rightChild == null)) {
                    queue.add(entry.rightChild);
                }
            }
        }
        return true;
    }



    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        } else {
            Boolean isFound = false;
            LinkedList<Entry> queue = new LinkedList<Entry>();
            for (Entry entry : entryList) {
                if (entry.elementName.equals(String.valueOf(o))) {
                    isFound = true;
                    queue.add(entry);
                    while (!queue.isEmpty()) {
                        if (!(queue.peek().rightChild == null)) {
                            queue.add(queue.peek().rightChild);
                        }
                        if (!(queue.peek().leftChild == null)) {
                            queue.add(queue.peek().leftChild);
                        }
                        if (queue.peek() == queue.peek().parent.leftChild) {
                            queue.peek().parent.leftChild = null;
                        }
                        if (queue.peek() == queue.peek().parent.rightChild) {
                            queue.peek().parent.rightChild = null;
                        }
                        if (queue.peek().parent.rightChild == null && queue.peek().parent.leftChild == null) {
                            queue.peek().parent.availableToAddRightChildren = true;
                            queue.peek().parent.availableToAddLeftChildren = true;
                        }
                        queue.peek().parent = null;
                        entryList.remove(queue.poll());
                    }
                    break;
                }
            }
            if (!isFound) {
                return false;
            } else return true;
        }
    }

    public int size() {
        return this.entryList.size() - 1;
    }

    public String getParent(String elementName) {
        for (Entry entry : entryList) {
            if (entry.elementName.equals(elementName)) {
                return entry.parent.elementName;
            }
        }
           return "null";
    }
}
