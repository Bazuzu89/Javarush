package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.javarush.task.task32.task3209.listeners.*;
import javax.swing.event.*;
import javax.swing.undo.*;



public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Новый" : controller.createNewDocument();
            case "Открыть" : controller.openDocument();
            case "Сохранить" : controller.saveDocument();
            case "Сохранить как..." : controller.saveDocumentAs();
            case "Выход" : controller.exit();
            case "О программе" : showAbout();
        }
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit() {
        this.controller.exit();
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPane1 = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPane1);
        JScrollPane scrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPane2);
        Dimension dimension = new Dimension(100, 100);
        tabbedPane.setPreferredSize(dimension);
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            controller.setPlainText(plainTextPane.getText());
        } else if (tabbedPane.getSelectedIndex() == 1) {
             plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return this.undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(tabbedPane, "Я крутая и длинная задача из Javarush", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
    }


}
