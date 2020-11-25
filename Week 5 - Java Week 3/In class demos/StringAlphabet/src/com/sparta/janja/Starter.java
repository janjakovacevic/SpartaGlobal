package com.sparta.janja;

public class Starter {
    public static void start(){
        String[] arrayOfStrings = {
                "abcdefghijklmnopqrstuvwxyz",
                "asdfghjkl",
                "lalalala",
                "spaRta Global",
                "123alala42 ",
                " ",
                "The Quick Brown Fox Jumps Over The Lazy Dog",
                "abcdefghijklmnopqrstuvwxyzThe Quick Brown Fox Jumps Over The Lazy Dog",
                "thisIsCamelCasing",
                null
        };

        try {
            for (int i = 0; i < arrayOfStrings.length; i++) {
                Printer.print(arrayOfStrings[i], StringOnlyAlphabet.containsEntireAlphabet(arrayOfStrings[i]));
            }
        } catch(NullPointerException e){
            Printer.printMessage(e.getMessage());
        }

    }
}
