package com.sparta.astha.engineering72.javabasic;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void getArea() {
       double area=Math.PI*radius*radius;
       Printer.print(area, "Circle");
    }
}
