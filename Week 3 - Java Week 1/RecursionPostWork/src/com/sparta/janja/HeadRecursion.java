package com.sparta.janja;

public class HeadRecursion {
    public static int headFactorial(int number) {
        if(number < 1) System.err.println("headFactorial: The value needs to be greater than 1!");
        else {
            if (number >= 2) {
                return headFactorial(number - 1) * number;
            } else {
                return number;
            }
        }
        return 1;
    }
}
