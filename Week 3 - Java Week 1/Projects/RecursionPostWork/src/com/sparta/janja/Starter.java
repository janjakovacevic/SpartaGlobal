package com.sparta.janja;

public class Starter {
    public static void start(){
        String welcome = "Welcome! By providing an integer number n to a program below, " +
                            "it will calculate nth Fibonacci number, a sequence of first n Fibonacci numbers " +
                            "as well the Factorial number of n in 4 different ways.";

        Printer.printWelcomeMessage(welcome);
        int input = ScannerClass.scanned();

//  1.1 Fibonacci Recursion
        Printer.printFibonacciRecursive(input, FibonacciRecursive.fibonacciRecursive(input));
        Printer.printFibonacciSequence(input, FibonacciSequenceRecursive.fibonacciSequenceRecursive(input));

//  1.2 Factorial Recursion
        Printer.printFactorialRecursive(input, FactorialRecursive.factorialRecursive(input));

//  1.3a Head Recursion
        Printer.printHeadRecursion(input, HeadRecursion.headFactorial(input));

//  1.3b Tail Recursion
        Printer.printTailRecursion(input, TailRecursion.tailFactorial(input));

//2. Iterative-Factorial create in Iterative
        Printer.printFactorialIterative(input, FactorialIterative.factorialIterative(input));
    }
}
