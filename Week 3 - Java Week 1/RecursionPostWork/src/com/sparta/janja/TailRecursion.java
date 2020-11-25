package com.sparta.janja;

public class TailRecursion {
    public static int tailFactorial(int number){
        if(number < 1) System.err.println("tailFactorial: The value needs to be greater than 1!");
        else {
            if (number == 1) {
                return number;
            } else {
                return tailFactorial(number - 1) * number;
            }
        }
        return 1;
    }
}
