package com.sparta.janja;

public class FactorialRecursive {
    public static int factorialRecursive(int number){
        if(number < 1) System.err.println("FactorialRecursive: The value needs to be greater than 1!");
        else {
            if (number == 1) return 1;
            return factorialRecursive(number - 1) * number;
        }
        return 1;
    }
}
