package com.sparta.astha.L;

import com.sparta.astha.O.Rectangle;

public class Square extends Rectangle {


    public Square(){

    }
//    public Square(double length){
//        this.setLength(length);
//
//    }

    public void setBreadth(double breadth){
        super.setBreadth(breadth);
        super.setLength(breadth);
    }



    public void setLength(double length){
        super.setLength(length);
        super.setBreadth(length);
    }



}
