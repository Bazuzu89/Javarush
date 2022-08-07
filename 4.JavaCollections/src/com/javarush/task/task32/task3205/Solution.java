package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/* 
Создание прокси-объекта
*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods sifwm = new SomeInterfaceWithMethodsImpl();
        CustomInvocationHandler cih = new CustomInvocationHandler(sifwm);
        ClassLoader classLoader = sifwm.getClass().getClassLoader();
        Class<?>[] interfaces = sifwm.getClass().getInterfaces();
        SomeInterfaceWithMethods result = (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, cih);
        return result;
    }
}
