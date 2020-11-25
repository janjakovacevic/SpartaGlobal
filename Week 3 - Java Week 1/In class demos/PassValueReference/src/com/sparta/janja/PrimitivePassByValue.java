package com.sparta.janja;

public class PrimitivePassByValue {
    public void passByValue(){
        // instance variable - state of the object
        int number = 5;
        changeNumber(number);
        // prints 5
        Printer.printNumber("passByValue", number);
    }

    private void changeNumber(int number) {
        // local variable
        // int number2 = 10;
        number = 10;
        // prints 10
        Printer.printNumber("changeNumber", number);
    }
}
