package com.javarush.task.task35.task3507;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    protected Class<?> findClass(String fileName) {
        File file = new File(fileName + ".class");
        try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
            byte[] byteArray = new byte[(int) file.length()];
            is.read(byteArray);
            Class c = defineClass(null, byteArray, 0, byteArray.length);
            return c;
        } catch (IOException e) {

        }
        return null;
    }
}
