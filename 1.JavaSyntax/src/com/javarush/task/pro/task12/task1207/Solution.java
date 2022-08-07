package com.javarush.task.pro.task12.task1207;

/* 
Какое число меньше
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size]; //создаем массив введенного с консоли размера
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt(); //заполняем введенными с консоли целыми числами
        }
        sortBubble(array);
        for (int element : array) {
            System.out.println(element);
        }

    }
    public static int[] sortBubble(int[] array) { //объявляем метод сортировки пузырьком
        for (int i = 0; i < array.length; i++) { //решили мы сортИровать пузырём значить
            for (int j = 1; j < array.length; j++) { //стали мы сортИровать
                if (array[j-1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array; //ну и отсортИровали
    }


}
