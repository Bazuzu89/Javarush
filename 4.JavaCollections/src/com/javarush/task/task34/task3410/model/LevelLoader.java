package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        if (level > 60) {
            level = level % 60;
        }
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            ArrayList<String> arrayList = new ArrayList<>();

            while (reader.ready()) {
                String string = reader.readLine();
                String[] array = string.split(" ");
                if (array.length == 2 && array[0].equals("Maze:") && array[1].equals(String.valueOf(level))) {
                    String line = "";
                    while (!line.equals("*************************************")) {
                        line = reader.readLine();
                        arrayList.add(line);
                    }
                    break;
                }
            }
            int width = Integer.parseInt(arrayList.get(1).split(" ")[2]);
            int height = Integer.parseInt(arrayList.get(2).split(" ")[2]);
            int y = Model.FIELD_CELL_SIZE / 2;

            for (int i = 6; i < arrayList.size() - 2; i++) {
                for (int j = 0; j < arrayList.get(i).length(); j++) {
                    if (arrayList.get(i).charAt(j) == 'X') {
                        walls.add(new Wall(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y));
                    } else if (arrayList.get(i).charAt(j) == '*') {
                        boxes.add(new Box(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y));
                    } else if (arrayList.get(i).charAt(j) == '.') {
                        homes.add(new Home(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y));
                    } else if (arrayList.get(i).charAt(j) == '&') {
                        boxes.add(new Box(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y));
                        homes.add(new Home(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y));
                    } else if (arrayList.get(i).charAt(j) == '@') {
                        player = new Player(Model.FIELD_CELL_SIZE / 2 + j * Model.FIELD_CELL_SIZE, y);
                    }
                }
                y += Model.FIELD_CELL_SIZE;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}
