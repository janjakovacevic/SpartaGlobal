package com.sparta.janja;

public class SumNumbers {
    public static int sumOddNumbers(int number){
        int sum = 0;
        if(number <= 0) System.err.println("sumOddNumbers: Input number needs to be greater than 0!");
        else {
            for (int i = 0; i <= number; i++) {
                if (i % 2 != 0) sum += i;
            }
        }
        return sum;
    }

    public static int sumEvenNumbers(int number){
        int sum = 0;
        if(number <= 0) System.err.println("sumEvenNumbers: Input number needs to be greater than 0!");
        else {
            for (int i = 0; i <= number; i++) {
                if (i % 2 == 0) sum += i;
            }
        }
        return sum;
    }
}
