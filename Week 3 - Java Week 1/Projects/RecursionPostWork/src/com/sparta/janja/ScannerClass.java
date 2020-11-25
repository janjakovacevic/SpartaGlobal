package com.sparta.janja;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerClass {
    public static int scanned() {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Please enter a number greater than 0. Then press enter::  ";
        Printer.printPromptMessage(prompt);
        while(true) {
            try {
                int value = scanner.nextInt();
                while(value <= 0) {
                    System.out.print("That’s not an integer greater than 0. Try again: ");
                    value = scanner.nextInt();
                    }
                return value;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.print("That’s not an integer. Try again: ");
            }
        }
    }
}
