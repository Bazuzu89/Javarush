package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.*;
import com.javarush.task.task32.task3209.*;

public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
