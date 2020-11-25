package com.sparta.astha.engineering72.javabasic;

public class Rectangle implements Shape{
    private double length;
    private double breadth;


    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void getArea() {
        double area=length*breadth;
        Printer.print(area, "rectangle");
    }
}
