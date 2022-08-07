package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    Shape shape;

    public RedShapeDecorator(Shape shape) {
        super(shape);
        this.shape = shape;
    }

    private void setBorderColor(Shape shape) {
        System.out.println(String.format("Setting the border color for %s to red.", shape.getClass().getSimpleName()));
    }

    @Override
    public void draw() {
        setBorderColor(shape);
        shape.draw();
    }
}
