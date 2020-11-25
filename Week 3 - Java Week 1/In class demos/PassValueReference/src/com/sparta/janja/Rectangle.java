package com.sparta.janja;

public class Rectangle {
    private int length;
    private int breadth;

    // type of method overloading (2 constructors)
    // same method name, different parameters

    // parameterized constructor: method with no return type
    //                            name of the class
    //                            passed parameters
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
     // default constructor
    public Rectangle(){}

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}
