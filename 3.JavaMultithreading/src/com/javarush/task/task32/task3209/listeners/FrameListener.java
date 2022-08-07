package com.javarush.task.task32.task3209.listeners;

import java.awt.event.*;
import com.javarush.task.task32.task3209.*;

public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.view.exit();
    }
}
