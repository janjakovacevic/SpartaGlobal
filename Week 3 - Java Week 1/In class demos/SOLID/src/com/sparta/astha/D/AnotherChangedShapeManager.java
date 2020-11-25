package com.sparta.astha.D;

import com.sparta.astha.O.Shape;

public class AnotherChangedShapeManager {

    private Shape shape;

    //constructor injection
    public AnotherChangedShapeManager(Shape shape) {
        this.shape = shape;
    }

    //setter injection
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getArea() {

            return shape.areaCalculate();
    }
}
