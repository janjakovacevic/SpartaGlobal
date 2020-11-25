package com.sparta;

public class Recursions {

    public void methodRecursion(int number){
        if(number > 0) {
            Printer.printBeforeRecursion(number);
            methodRecursion(number - 1);
            Printer.printAfterRecursion(number);
        }
    }

}
