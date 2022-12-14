package com.javarush.task.task35.task3513;

import java.awt.event.*;

public class Controller extends KeyAdapter {
    Model model;
    View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public View getView() {
        return this.view;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!(view.isGameLost && view.isGameWon)) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_UP : model.up(); break;
                case KeyEvent.VK_RIGHT : model.right(); break;
                case KeyEvent.VK_DOWN : model.down(); break;
                case KeyEvent.VK_LEFT : model.left(); break;
                case KeyEvent.VK_Z : model.rollback(); break;
                case KeyEvent.VK_R : model.randomMove(); break;
                case KeyEvent.VK_A : model.autoMove(); break;
            }
        }
        if (model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }
        view.repaint();
    }
}
