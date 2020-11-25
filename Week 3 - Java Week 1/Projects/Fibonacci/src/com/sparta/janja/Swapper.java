package com.sparta.janja;

public class Swapper {
    public static String swap(int firstNumber, int secondNumber){
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
        return (firstNumber + " " + secondNumber);
    }
}
