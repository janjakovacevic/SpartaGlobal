package com.sparta.janja;

public class FibonacciIterative {
    public static int fibonacciIterative(int nthNumber) {
        if (nthNumber <= 1) return nthNumber;
        int currentNumber = 1;
        int previousNumber = 1;
        for (int i = 2; i < nthNumber; i++) {
            int temp = currentNumber;
            currentNumber += previousNumber;
            previousNumber = temp;
        }
        return currentNumber;
    }
}
