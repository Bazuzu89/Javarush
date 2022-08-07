package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader;

    public Model() {
        try {
            levelLoader = new LevelLoader(Paths.get(getClass().getResource("../res/levels.txt").toURI()));
        } catch(URISyntaxException e) {
        }
}
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel += 1;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction) || checkBoxCollisionAndMoveIfAvailable(direction) ) {
            return;
        }
        Player player = gameObjects.getPlayer();
        switch (direction) {
            case DOWN : player.move(0, Model.FIELD_CELL_SIZE); break;
            case UP : player.move(0, -Model.FIELD_CELL_SIZE); break;
            case RIGHT : player.move(Model.FIELD_CELL_SIZE, 0); break;
            case LEFT : player.move(-Model.FIELD_CELL_SIZE, 0); break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        boolean isWallCollision = false;
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                isWallCollision = true;
                break;
            }
        }
        return isWallCollision;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Box boxToMove = null;
        Player player = gameObjects.getPlayer();
        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {
                boxToMove = box;
                break;
            }
        }
        boolean isNotMovable = false;
        if (boxToMove != null) {
            for (Box box : gameObjects.getBoxes()) {
                if (boxToMove.isCollision(box, direction)) {
                    isNotMovable = true;
                    break;
                }
            }
            if (!isNotMovable) {
                for (Wall wall : gameObjects.getWalls()) {
                    if (boxToMove.isCollision(wall, direction)) {
                        isNotMovable = true;
                        break;
                    }
                }
            }
        }
        if (!isNotMovable  && boxToMove != null) {
            switch (direction) {
                case DOWN : boxToMove.move(0, Model.FIELD_CELL_SIZE); break;
                case UP : boxToMove.move(0, -Model.FIELD_CELL_SIZE); break;
                case RIGHT : boxToMove.move(Model.FIELD_CELL_SIZE, 0); break;
                case LEFT : boxToMove.move(-Model.FIELD_CELL_SIZE, 0); break;
            }
        }
        return isNotMovable;
    }

    public void checkCompletion() {
        for (Home home : gameObjects.getHomes()) {
            boolean isHomeEmpty = true;
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    isHomeEmpty = false;
                }
            }
            if (isHomeEmpty) {
                return;
            }
        }
        eventListener.levelCompleted(currentLevel);
    }
}
