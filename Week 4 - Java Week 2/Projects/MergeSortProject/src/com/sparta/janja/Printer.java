package com.sparta.janja;

public class Printer {
    public static void printOriginalArray(int[] array){
        System.out.print("Original Array: [ ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("]");
    }
    
    public static void printSortedArray(int[] array){
        System.out.print("Sorted Array: [ ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("]");
        System.out.println("-----------------------------------------");
    }

    public static void print(String message){
        System.out.println(message);
        System.out.println("-----------------------------------------");
    }

}
