package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class clazz = Collections.class;
        Class[] declaredClasses = clazz.getDeclaredClasses();
        for (Class<?> clazz1 : declaredClasses) {
            try {
                if (Modifier.isPrivate(clazz1.getModifiers()) && Modifier.isStatic(clazz1.getModifiers())) {
                    Constructor constructor = clazz1.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Method get = clazz1.getMethod("get", int.class);
                    get.setAccessible(true);
                    get.invoke(constructor.newInstance(), 0);
                }
            } catch (InvocationTargetException e) {
                return clazz1;
            } catch (Exception nsme) {

                }
        }
        return null;
    }
}
