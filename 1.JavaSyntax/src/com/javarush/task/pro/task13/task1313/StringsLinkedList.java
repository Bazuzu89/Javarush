package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        Node currentElement = new Node();
        currentElement.value = value;
        if (first.next == null) {
            first.next = currentElement;
            currentElement.prev = first;
            currentElement.next = last;
            last.prev = currentElement;
        } else {
            last.prev.next = currentElement;
            currentElement.next = last;
            currentElement.prev = last.prev;
            last.prev = currentElement;
        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
