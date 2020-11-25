package com.sparta.janja;

public class Starter {

    public static void start(){
        int[] array1 = {7, 2, 5, 1, 9, 4, 3};
        int[] array2 = {};
        int[] array3 = {9, 0, -9, 54, 23};
        int[] array4 = {10, 9, 6, 4};
        int[] array5 = {-2, -5, -10, -1, -3};

        startMerge(array1);
        startMerge(array2);
        startMerge(array3);
        startMerge(array4);
        startMerge(array5);
    }

    private static void startMerge(int[] array){
        try {
            Printer.printOriginalArray(array);
            MergeSort.mergeSort(array);
            Printer.printSortedArray(array);
        } catch (Exception e) {
            // prints call stack
            // e.printStackTrace();
            Printer.print(e.getMessage());
        }
    }

}
