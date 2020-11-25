package com.sparta.janja;

public class FizzBuzzGenerator {

    public static String checkFizzBuzz(int number) {
        String checkValue = null;
        if(number % 3 == 0 && number % 5 == 0){
            checkValue = "FizzBuzz";
        }
        else if(number % 3 == 0){
            checkValue = "Fizz";
        }
        else if(number % 5 == 0){
            checkValue = "Buzz";
        }
        return checkValue;
    }
}
