package com.sparta.janja;

public class FibonacciSequenceIterative {
    public static String fibonacciSequenceIterative(int number) {
        String sequence = "";
        for (int i = 1; i <= number; i++) {
            sequence += FibonacciIterative.fibonacciIterative(i) + " ";
        }
        return sequence;
    }
}
