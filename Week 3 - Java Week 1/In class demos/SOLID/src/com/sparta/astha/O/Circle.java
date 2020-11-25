package com.sparta.astha.O;

public class Circle implements Shape {
    private double radius;

    public Circle(){

    }

    public Circle(double radius){
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double areaCalculate() {
        return (22/7)*getRadius()*getRadius();
    }
}
