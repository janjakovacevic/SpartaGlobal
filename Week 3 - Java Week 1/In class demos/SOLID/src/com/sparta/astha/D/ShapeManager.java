package com.sparta.astha.D;

import com.sparta.astha.L.Square;
import com.sparta.astha.O.Circle;
import com.sparta.astha.O.Rectangle;

public class ShapeManager {
     //tight coupling
    Rectangle rectangle=new Rectangle(4,5);
    Circle circle=new Circle(2);

    public double[] getAreas(){
        double[] areas=new double[2];
        areas[0] = rectangle.getLength() * rectangle.getLength();
        areas[1] = circle.getRadius() * circle.getRadius() * Math.PI;

        return areas;
    }
}

//        areas[0]=rectangle.areaCalculate();
//        areas[1]=circle.areaCalculate();