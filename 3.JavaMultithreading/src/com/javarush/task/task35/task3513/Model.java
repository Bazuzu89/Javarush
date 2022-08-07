package com.javarush.task.task35.task3513;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class Model {
    private final static int FIELD_WIDTH = 4;
    public Tile[][] gameTiles;
    int score;
    int maxTile;
    Stack<Integer> previousScores;
    Stack<Tile[][]> previousStates;
    private boolean isSaveNeeded = true;

    public Tile[][] getGameTiles() {
       return this.gameTiles;
    }

    public Model() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        this.maxTile = 0;
        this.score = 0;
        this.previousScores = new Stack();
        this.previousStates = new Stack();
        resetGameTiles();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] state = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                state[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(state);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!(previousStates.isEmpty() || previousScores.isEmpty())) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private void addTile() {
        List<Tile> emptyTilesList = getEmptyTiles();
        if (!emptyTilesList.isEmpty()) {
            int indexOfAddedTile = (int) (emptyTilesList.size() * Math.random());
            int tileValue = Math.random() < 0.9 ? 2 : 4;
            emptyTilesList.get(indexOfAddedTile).setValue(tileValue);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTilesList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTilesList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTilesList;
    }

    public void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean gapsArePresent = true;
        boolean isChanged = false;
        while (gapsArePresent) {
            for (int i = tiles.length - 1; i > 0; i--) {
                if (tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                    tiles[i - 1].setValue(tiles[i].value);
                    tiles[i].setValue(0);
                    isChanged = true;
                }
            }
            gapsArePresent = false;
            for (int i = 1; i < tiles.length; i++) {
                if (tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                    gapsArePresent = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for (int j = 1; j < tiles.length; j++) {
                if (tiles[j-1].value == tiles[j].value && tiles[j-1].value != 0) {
                    int newValue = tiles[j-1].value * 2;
                    tiles[j-1].setValue(newValue);
                    if (newValue > maxTile) {
                        maxTile = newValue;
                    }
                    score = score + newValue;
                    tiles[j].setValue(0);
                    isMerged = true;
                }
            }
        compressTiles(tiles);
        return isMerged;
    }

    void left() {
        boolean isCompressed = false;
        boolean isMerged = false;
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        for (int i = 0; i < gameTiles.length; i++) {
            isCompressed = compressTiles(gameTiles[i]);
            isMerged = mergeTiles(gameTiles[i]);
            isSaveNeeded = true;
        }
        if (isCompressed || isMerged) {
            addTile();
        }
    }

    private void pivotArray() {
        Tile[][] newArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newArray[i][j] = new Tile();
            }
        }
        for (int i = 0; i < newArray.length; i++) {
           for (int j = 0; j < newArray[i].length; j++) {
               newArray[i][j].setValue(gameTiles[j][3-i].value);
           }
        }
        gameTiles = newArray;
    }

    void up() {
        saveState(gameTiles);
        pivotArray();
        left();
        pivotArray();
        pivotArray();
        pivotArray();
    }

    void right() {
        saveState(gameTiles);
        pivotArray();
        pivotArray();
        left();
        pivotArray();
        pivotArray();
    }

    void down() {
        saveState(gameTiles);
        pivotArray();
        pivotArray();
        pivotArray();
        left();
        pivotArray();
    }

    public boolean canMove() {
        boolean canMove = false;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    canMove = true;
                }
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value) {
                    canMove = true;
                }
            }
        }
        for (int i = 1; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value == gameTiles[i-1][j].value) {
                    canMove = true;
                }
            }
        }
        return canMove;
    }

    public void randomMove() {
        int index = (int) (Math.random() * 100) % 4;
        switch (index) {
            case 0 : up(); break;
            case 1 : right(); break;
            case 2 : down(); break;
            case 3 : left(); break;
        }
    }

    public boolean hasBoardChanged() {
        int gameTilesValuesSum = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTilesValuesSum += gameTiles[i][j].value;
            }
        }
        int previousStateTilesValueSum = 0;
        for (int i = 0; i < previousStates.peek().length; i++) {
            for (int j = 0; j < previousStates.peek()[i].length; j++) {
                previousStateTilesValueSum += previousStates.peek()[i][j].value;
            }
        }
        return gameTilesValuesSum - previousStateTilesValueSum != 0;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this :: left));
        queue.offer(getMoveEfficiency(this :: right));
        queue.offer(getMoveEfficiency(this :: up));
        queue.offer(getMoveEfficiency(this :: down));
        queue.peek().getMove().move();
    }
}
