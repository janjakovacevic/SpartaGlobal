package com.sparta.astha.engineering72.javabasic;

public class Starter {
    public static void start(){
        ShapeFactory shapeFactory=new ShapeFactory();

        Shape shape2=shapeFactory.getShape("Circle");
        shape2.getArea();

        Shape shape3=shapeFactory.getShape("Rectangle");
        shape3.getArea();

        Shape shape4=shapeFactory.getShape("Square");
        shape4.getArea();
    }
}
