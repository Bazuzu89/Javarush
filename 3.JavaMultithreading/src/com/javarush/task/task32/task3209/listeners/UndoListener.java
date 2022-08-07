package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.*;
import javax.swing.undo.*;

public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void undoableEditHappened(UndoableEditEvent event) {
        undoManager.addEdit(event.getEdit());
    }
}
