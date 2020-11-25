package com.sparta.janja;

public class Printer {

    public static void printWelcomeMessage(String message){
        System.out.println(message);
    }

    public static void printPromptMessage(String message){
        System.out.println(message);
    }
    public static void printFibonacciRecursive(int n, int result){
        System.out.println("FibonacciRecursive: " + n + "th Fibonacci number is " + result);
    }

    public static void printFibonacciSequence(int n, String result){
        System.out.println("FibonacciSequenceRecursive: First " + n + " Fibonacci numbers are " + result);
    }

    public static void printFactorialRecursive(int n, int result){
        System.out.println("FactorialRecursive: Factorial of " + n + " is " + result);
    }

    public static void printHeadRecursion(int n, int result){
        System.out.println("HeadRecursion: Factorial of " + n + " is " + result);
    }

    public static void printTailRecursion(int n, int result){
        System.out.println("TailRecursion: Factorial of " + n + " is " + result);
    }

    public static void printFactorialIterative(int n, int result){
        System.out.println("FactorialIterative: Factorial of " + n + " is " + result);
    }


}
