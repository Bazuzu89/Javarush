package com.javarush.task.task32.task3209;

import javax.swing.text.html.*;
import java.io.*;
import javax.swing.text.Document;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return this.document;
    }

    public void resetDocument() {
        if (document != null) {
        document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit editorKit = new HTMLEditorKit();
        document = (HTMLDocument) editorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit editor = new HTMLEditorKit();
        try {
        editor.read(reader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        HTMLEditorKit editor = new HTMLEditorKit();
        try {
        editor.write(writer, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("Мой HTML редактор");
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile) ) {
                HTMLEditorKit editor = new HTMLEditorKit();
                editor.read(reader, document, 0);
                resetDocument();
                view.resetUndo();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
            if (currentFile != null) {
                view.setTitle(currentFile.getName());
                try (FileWriter fileWriter = new FileWriter(currentFile)) {
                    HTMLEditorKit editor = new HTMLEditorKit();
                    editor.write(fileWriter, document, 0, document.getLength());
                } catch (Exception e) {
                    ExceptionHandler.log(e);
                }
            } else {
                saveDocumentAs();
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                HTMLEditorKit editor = new HTMLEditorKit();
                editor.write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
