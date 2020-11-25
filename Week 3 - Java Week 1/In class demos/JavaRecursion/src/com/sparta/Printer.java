package com.sparta;

public class Printer {
    public static void printBeforeRecursion(int number){
        System.out.println("Before recursion::" + number);
    }
    public static void printAfterRecursion(int number){
        System.out.println("After recursion::" + number);
    }

    public static void printFactorialValue(int number, int factorialValue){
        System.out.println("Factorial of " + number + " is " + factorialValue);
    }
}
