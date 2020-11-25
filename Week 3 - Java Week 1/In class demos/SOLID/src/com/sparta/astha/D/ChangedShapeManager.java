package com.sparta.astha.D;

import com.sparta.astha.O.Shape;

import java.util.ArrayList;
import java.util.List;

public class ChangedShapeManager {

    private List<Shape> shapes;

    {
        shapes=new ArrayList<>();
    }



    public void addShapes(Shape shape){
        shapes.add(shape);
    }

    public double[] getAreas() {
        double[] areas = new double[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            areas[i] = shapes.get(i).areaCalculate();
        }
       return areas;
    }
}
