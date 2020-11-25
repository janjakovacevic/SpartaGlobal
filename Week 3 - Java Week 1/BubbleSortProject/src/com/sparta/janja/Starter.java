package com.sparta.janja;

public class Starter {
    public static void start(){
        int[] array1 = {9,5,8,4,7,1,3,6,2,0,-5,-8};
        int[] array2 = {12, 43, 23, 57, 74, 90, 14, -3, 0, -34};
        int[] array3 = {};
        int[] array4 = {5, 0, -1, -2};

        int[] array5 = {9, 5, 8, 4, 7, 1, 3, 6, 2, 0, -5, -8};
        int[] array6 = {12, 43, 23, 57, 74, 90, 14, -3, 0, -34};
        int[] array7 = {};
        int[] array8 = {5, 0, -1, -2};

        try {
            startIterativeBubbleSort(array1);
            startIterativeBubbleSort(array2);
            startIterativeBubbleSort(array3);
            startIterativeBubbleSort(array4);

            startRecursiveBubbleSort(array5);
            startRecursiveBubbleSort(array6);
            startRecursiveBubbleSort(array7);
            startRecursiveBubbleSort(array8);

        } catch (Exception e) {
            Printer.print(e.getMessage());
        }

    }

    private static void startIterativeBubbleSort(int[] array){
        Printer.printOriginalArray(array);
        BubbleSortIterative.bubbleSort(array);
        Printer.printIterativelySortedArray(array);
    }

    private static void startRecursiveBubbleSort(int[] array){
        Printer.printOriginalArray(array);
        BubbleSortRecursive.bubbleSort(array, array.length);
        Printer.printRecursivelySortedArray(array);
    }
}
