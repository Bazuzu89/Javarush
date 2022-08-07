package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.PINK);
        graphics.drawRect(this.getX() - Model.FIELD_CELL_SIZE / 2, this.getY() - Model.FIELD_CELL_SIZE / 2, Model.FIELD_CELL_SIZE, Model.FIELD_CELL_SIZE);
    }
}
