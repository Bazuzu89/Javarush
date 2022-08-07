package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawOval(this.getX() - Model.FIELD_CELL_SIZE / 2, this.getY() - Model.FIELD_CELL_SIZE / 2, Model.FIELD_CELL_SIZE, Model.FIELD_CELL_SIZE);
        graphics.fillOval(this.getX() - Model.FIELD_CELL_SIZE / 2, this.getY() - Model.FIELD_CELL_SIZE / 2, Model.FIELD_CELL_SIZE, Model.FIELD_CELL_SIZE);
    }
}
