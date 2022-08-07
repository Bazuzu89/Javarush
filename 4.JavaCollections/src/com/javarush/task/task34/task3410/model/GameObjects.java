package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    private Set<Box> boxes;
    private Set<Home> homes;
    private Set<Wall> walls;
    private Player player;

    public Set<GameObject> getAll() {
        Set<GameObject> resultSet = new HashSet<>();
        resultSet.addAll(boxes);
        resultSet.addAll(homes);
        resultSet.addAll(walls);
        resultSet.add(player);
        return resultSet;
    }



    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.boxes = boxes;
        this.homes = homes;
        this.walls = walls;
        this.player = player;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public Player getPlayer() {
        return player;
    }
}
