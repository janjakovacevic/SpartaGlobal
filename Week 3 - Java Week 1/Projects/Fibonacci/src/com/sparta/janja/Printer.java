package com.sparta.janja;

public class Printer {

    public static void printWelcomeMessage(String message){
        System.out.println(message);
    }

    public static void printPromptMessage(String message){
        System.out.println(message);
    }

    public static void printBeforeSwapped(int x, int y){
        System.out.println("Values before swapping: first value = " + x + ", second value = " + y);
    }

    public static void printAfterSwapped(String result){
        System.out.println("Values after swapping: first value = " + result.substring(0,1) + ", seconf value = " + result.substring(2,3));
    }

    public static void printSumOddNumbers(int n, int result){
        System.out.println("SumOddNumbers: Sum of odd numbers from 1 to " + n + " inclusive, is " + result);
    }

    public static void printSumEvenNumbers(int n, int result){
        System.out.println("SumEvenNumbers: Sum of even numbers from 1 to " + n + " inclusive, is " + result);
    }

    public static void printFibonacciIterative(int n, int result){
        System.out.println("FibonacciIterative: " + n + "th Fibonacci number is " + result);
    }

    public static void printFibonacciSequence(int n, String result){
        System.out.println("FibonacciSequenceIterative: First " + n + " Fibonacci numbers are " + result);
    }


}
