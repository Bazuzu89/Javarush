package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.*;
import com.javarush.task.task32.task3209.*;
import javax.swing.JMenuItem;

public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
        this.undoMenuItem.setText("Отменить");
        this.redoMenuItem.setText("Вернуть");
    }

    public void menuSelected(MenuEvent menuEvent) {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }

    public void menuDeselected(MenuEvent menuEvent) {

    }
    public void menuCanceled(MenuEvent menuEvent) {

    }

}
