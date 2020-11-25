package com.sparta.janja;

public class Palindrome {

    public static boolean isPalindrome(String wordToCheck) {

        if(wordToCheck.length() > 2) {
            String word = wordToCheck.toLowerCase();
            int back = word.length() - 1;
            // front pointing to the front
            // back pointing to the back
            // loops until there are characters to compare
            for (int front = 0; front <= back; front++, back--) {
                // mismatch found
                if (word.charAt(front) != word.charAt(back)) return false;
            }
            return true;
        }

        else{
            // needs to be of length of at least 3, so if not, we return false by default
            return false;
        }

    }

    public static String longestPalindrome(String sentence) {
        if(sentence.length() < 3) {
            System.err.println("longestPalindrome: The string needs to be of length of at least 3!");
            return "";
        }
        else {
            String longestWord = "";
            int currentWordLength = 0;
            int longestWordLength = 0;


            String[] words = sentence.replaceAll("\\p{Punct}", " ").split(" ");

            for (String currentWord : words) {
                currentWordLength = currentWord.length();
                if (isPalindrome(currentWord) && (currentWordLength > longestWordLength)) {
                    longestWordLength = currentWordLength;
                    longestWord = currentWord;
                }
            }

            return longestWord;
        }
    }
}
