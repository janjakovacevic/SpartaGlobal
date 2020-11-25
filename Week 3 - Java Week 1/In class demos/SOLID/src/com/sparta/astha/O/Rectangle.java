package com.sparta.astha.O;

public class Rectangle implements Shape {
    private double length;
    private double breadth;

    public Rectangle(){

    }

    public Rectangle(double length, double breadth){
        this.length=length;
        this.breadth=breadth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    @Override
    public double areaCalculate() {
        return getBreadth()*getLength();
    }
}
