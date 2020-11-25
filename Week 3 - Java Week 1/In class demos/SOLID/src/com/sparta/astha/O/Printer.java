package com.sparta.astha.O;

import com.sparta.astha.L.Square;

public class Printer {

    public static void printArea(){
        Rectangle rectangle=new Rectangle();
        rectangle.setBreadth(4);
        rectangle.setLength(5);

        Rectangle square=new Square();
        square.setBreadth(5);
        square.setLength(5);
        Area area=new Area();
        Double areaCalculation=area.calculateArea(rectangle);
        System.out.println("Area of shape-Rectangle::"+areaCalculation);

        Double areaCalculation1=area.calculateArea(square);
        System.out.println("Area of shape-Square::"+areaCalculation1);

    }
}
