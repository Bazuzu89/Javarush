package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import com.javarush.task.task32.task3209.*;
import java.awt.event.*;

public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }


    public void actionPerformed(ActionEvent action) {
        this.view.undo();
    }
}
