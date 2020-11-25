package com.sparta;

public class Factorial {
    public static int factorialRecursive(int number){
        int factorialOutput = 1;
        if(number <= 1) return 1;
        else{ factorialOutput = factorialRecursive(number-1) * number;}
        return factorialOutput;
    }

    public static int myFactorialRecursive(int number){
        if(number <= 1) return 1;

        return factorialRecursive(number-1) * number;
    }
}
