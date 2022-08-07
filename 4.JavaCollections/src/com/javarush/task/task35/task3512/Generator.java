package com.javarush.task.task35.task3512;

import java.lang.reflect.Constructor;

public class Generator<T> {
    Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() throws InstantiationException, IllegalAccessException  {
        return clazz.newInstance();
    }
}
