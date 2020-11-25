package com.sparta.janja;

public class ObjectReferencePassByValue {
    public void passByValue(){
        Rectangle rectangle = new Rectangle(); //default constructor
        rectangle.setLength(50);
        rectangle.setBreadth(20);

        changeObject(rectangle);
        // prints 50, 20
        Printer.printObject("passByValue", rectangle);
    }

    // sending a copy of the object reference, not the object reference itself
    private void changeObject(Rectangle rectangle) {
      // removing this line, print statement above would print 100, 60
        rectangle = new Rectangle();
        rectangle.setLength(100);
        rectangle.setBreadth(60);
        // prints 100, 60
        Printer.printObject("changeObject", rectangle);

    }
}
