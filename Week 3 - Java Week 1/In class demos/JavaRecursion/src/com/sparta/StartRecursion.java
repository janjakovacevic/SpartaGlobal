package com.sparta;

public class StartRecursion {
    public static void start() {
//        Recursions recursion = new Recursions();
//        recursion.methodRecursion(5);
        int input = 3;
        if(input < 1){
            System.err.println("Please enter a number greater than 0");
        }
        else {
            int factorialValue = Factorial.factorialRecursive(input);
            Printer.printFactorialValue(input, factorialValue);
        }
        int myInput = 4;
        int myFactorialValue = Factorial.myFactorialRecursive(myInput);
        Printer.printFactorialValue(myInput, myFactorialValue);
    }
}
