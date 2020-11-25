package com.sparta.janja;

public class Printer {

    public static void printBeforeMerging(int[] array1, int[] array2){
        System.out.print("First array before merging: [ ");
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        System.out.println("]");

        System.out.print("Second array before merging: [ ");
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println("]");
    }

    public static void printAfterMerging(int[] array){
        System.out.print("Output array after merging: [ ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
        System.out.println("-----------------------------------------");
    }

    public static void print(String message){
        System.out.println(message);
        System.out.println("-----------------------------------------");
    }
}
