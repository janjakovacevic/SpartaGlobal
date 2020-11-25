package com.sparta.astha.engineering72.javabasic;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public void getArea() {
        double area=length*length;
        Printer.print(area, "square");
    }
}
