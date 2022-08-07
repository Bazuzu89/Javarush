package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.*;
import com.javarush.task.task32.task3209.*;
import javax.swing.JMenu;
import java.awt.Menu;
import java.awt.Component;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    public void menuSelected(MenuEvent menuEvent) {
        JMenu menu = (JMenu) menuEvent.getSource();
        for (Component component : menu.getMenuComponents()) {
            component.setEnabled(view.isHtmlTabSelected());
        }

    }
    public void menuDeselected(MenuEvent menuEvent) {

    }
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
