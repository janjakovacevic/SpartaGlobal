package com.sparta.janja;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerClass {
    public static int scanned() {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Please enter a number greater than 0. Then press enter::  ";
        Printer.printPromptMessage(prompt);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.print("That’s not an integer. Try again: ");
            }
        }
    }

    public static int scanForFirstNumber() {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Please enter any number. This is going to be the first value::  ";
        Printer.printPromptMessage(prompt);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.print("That’s not an integer. Try again: ");
            }
        }
    }

    public static int scanForSecondNumber() {
        Scanner scanner = new Scanner(System.in);
        String prompt = "Please enter another number. This is going to be the second value::  ";
        Printer.printPromptMessage(prompt);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.print("That’s not an integer. Try again: ");
            }
        }
    }

}
