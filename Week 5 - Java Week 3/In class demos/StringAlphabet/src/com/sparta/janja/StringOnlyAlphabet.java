package com.sparta.janja;

public class StringOnlyAlphabet {
    public static boolean containsOnlyAlphabet(String stringToCheck) throws NullPointerException{
        return (!stringToCheck.equals("") &&
                (stringToCheck != null) &&
                stringToCheck.matches("^[a-zA-Z]*$"));
    }

    public static boolean containsEntireAlphabet(String stringToCheck) {
        return stringToCheck.toLowerCase()
                .replaceAll("[^a-z]", "")
                .replaceAll("(.)(?=.*\\1)", "")
                .length() == 26;
    }

}
