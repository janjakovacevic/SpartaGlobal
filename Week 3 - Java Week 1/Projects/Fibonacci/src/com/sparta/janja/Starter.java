package com.sparta.janja;

public class Starter {
    public static void start(){
        String welcome = "Welcome! By providing initial two integer numbers to a program below, " +
                "it will swap them for you. By inputting another integer, the program will " +
                "iteratively calculate the sum of all odd, then even numbers until the provided number, " +
                "after which it will find nth Fibonacci number and display a sequence of first n Fibonacci numbers.";

        Printer.printWelcomeMessage(welcome);
        int firstNumber = ScannerClass.scanForFirstNumber();
        int secondNumber = ScannerClass.scanForSecondNumber();
        Printer.printBeforeSwapped(firstNumber, secondNumber);
        Printer.printAfterSwapped(Swapper.swap(firstNumber, secondNumber));

        int input = ScannerClass.scanned();

        Printer.printSumOddNumbers(input, SumNumbers.sumOddNumbers(input));
        Printer.printSumEvenNumbers(input, SumNumbers.sumEvenNumbers(input));
        Printer.printFibonacciIterative(input, FibonacciIterative.fibonacciIterative(input));
        Printer.printFibonacciSequence(input, FibonacciSequenceIterative.fibonacciSequenceIterative(input));

    }
}
