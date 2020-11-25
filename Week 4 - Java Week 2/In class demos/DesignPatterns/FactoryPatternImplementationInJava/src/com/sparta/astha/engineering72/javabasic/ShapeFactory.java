package com.sparta.astha.engineering72.javabasic;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        switch (shapeType) {
            case "Circle":
                return new Circle(5.0);
            case "Rectangle":
                return new Rectangle(2.0, 1.0);
            case "Square":
                return new Square(3.0);
            default:
                return null;
        }
    }
//    public Shape getShape(String shapeType){
//        if(shapeType==null){
//            return null;
//        }
//
//        else if(shapeType.equalsIgnoreCase("Circle")){
//            return new Circle(5.0);
//        }
//
//        else if(shapeType.equalsIgnoreCase("Rectangle")){
//            return new Rectangle(2.0, 1.0);
//        }
//        else if(shapeType.equalsIgnoreCase("Square")){
//            return new Square(3.0);
//        }
//        return null;
//    }
}
