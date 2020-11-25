package com.sparta.janja;

public class FactorialIterative {
    public static int factorialIterative(int number){
        int factorialValue = 1;
        if(number < 1) System.err.println("FactorialIterative: The value needs to be greater than 1!");
        else {
            for (int i = 1; i <= number; i++) {
                factorialValue *= i;
            }
        }
        return factorialValue;
    }
}
