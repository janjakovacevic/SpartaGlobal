package com.sparta.janja;

public class Printer {

    public static void printIsPalindrome(String word, boolean result){
        if(result == true) System.out.println("Word '" + word + "' is a palindrome.");
        else{ System.out.println("Word '" + word + "' is not a palindrome.");}
    }

    public static void printLongestPalindrome(String sentence, String result){
        if(result.equals("")) System.out.println("Sentence '" + sentence + "' has no palindromes.");
        else{ System.out.println("The longest palindrome in '" + sentence + "' is word '" + result + "'");}
    }

}
