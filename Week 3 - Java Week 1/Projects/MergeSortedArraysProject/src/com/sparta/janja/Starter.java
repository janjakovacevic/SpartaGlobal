package com.sparta.janja;

import java.util.ArrayList;

public class Starter {

    public static void start(){

        int[] array1 = {8, 10, 25};
        int[] array2 = {-9};
        int[] array3 = {1, 5, 7};
        int[] array4 = {-3, -2, 0, 1, 4};
        int[] array5 = {3, 8, 2, 4};
        int[] array6 = {};

        startMergingArrays(array1, array2);
        startMergingArrays(array1, array3);
        startMergingArrays(array3, array4);
        startMergingArrays(array2, array6);
        startMergingArrays(array4, array6);
        startMergingArrays(array4, array5);
        startMergingArrays(array5, array6);

    }

    private static void startMergingArrays(int[] array1, int[] array2){
        try {
            Printer.printBeforeMerging(array1, array2);
            int[] array = Merger.mergeSortedArrays(array1, array2);
            Printer.printAfterMerging(array);
        } catch (Exception e) {
            Printer.print(e.getMessage());
        }
    }
}
