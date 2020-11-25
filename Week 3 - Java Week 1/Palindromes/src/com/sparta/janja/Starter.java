package com.sparta.janja;

public class Starter {
    public static void start(){
        String wordPalindrome = "level";
        String wordNotPalindrome = "name";
        String sentencePalindrome = "ABBA won the Eurovision Song Contest in April 1974 with a song 'Waterloo'.";
        String sentenceNoPalindrome = "There are no palindromes here";

        Printer.printIsPalindrome(wordPalindrome, Palindrome.isPalindrome(wordPalindrome));
        Printer.printIsPalindrome(wordNotPalindrome, Palindrome.isPalindrome(wordNotPalindrome));
        Printer.printLongestPalindrome(sentencePalindrome, Palindrome.longestPalindrome(sentencePalindrome));
        Printer.printLongestPalindrome(sentenceNoPalindrome, Palindrome.longestPalindrome(sentenceNoPalindrome));

    }
}
