package com.sparta.janja;

public class Printer {

    public static void printOriginalArray(int[] array) {
        System.out.print("Original array: [ ");
        for (int i : array)
            System.out.print(i + " ");
        System.out.println("]");
    }

    public static void printIterativelySortedArray(int[] array) {
        System.out.print("Iteratively sorted array: [ ");
        for (int i : array)
            System.out.print(i + " ");
        System.out.println("]");
        System.out.println("--------------------------------------------------------------");
    }

    public static void printRecursivelySortedArray(int[] array) {
        System.out.print("Recursively sorted array: [ ");
        for (int i : array)
            System.out.print(i + " ");
        System.out.println("]");
        System.out.println("--------------------------------------------------------------");
    }

    public static void print(String message) {
        System.out.println(message);
        System.out.println("--------------------------------------------------------------");
    }
}
