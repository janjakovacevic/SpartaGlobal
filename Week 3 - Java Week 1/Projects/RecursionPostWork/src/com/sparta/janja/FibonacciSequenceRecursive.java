package com.sparta.janja;

public class FibonacciSequenceRecursive {
    public static String fibonacciSequenceRecursive(int number) {
        String sequence = "";
        for (int i = 1; i <= number; i++) {
            sequence += FibonacciRecursive.fibonacciRecursive(i) + " ";
        }
        return sequence;
    }
}
