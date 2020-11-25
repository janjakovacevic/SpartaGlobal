package com.sparta.astha.D;

import com.sparta.astha.ChangedShapeManager;
import com.sparta.astha.L.Square;
import com.sparta.astha.O.Circle;
import com.sparta.astha.O.Rectangle;

import java.util.Arrays;

public class PrintShapesArea {

    public static void printArea(){

        ChangedShapeManager changedShapeManager=new ChangedShapeManager();
        changedShapeManager.addShapes(new Rectangle(5,4));
        Square square=new Square();
        square.setBreadth(5);
        square.setLength(2);
        changedShapeManager.addShapes(square);
        changedShapeManager.addShapes(new Circle(2));

        System.out.println(Arrays.toString(changedShapeManager.getAreas()));

    }
}
