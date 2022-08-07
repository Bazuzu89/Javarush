package com.javarush.task.task27.task2712.kitchen;

import java.util.Observer;
import java.util.Observable;
import com.javarush.task.task27.task2712.*;

public class Waiter implements Observer {

    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage(arg.toString() + " was cooked by " + observable.toString());
    }
}
