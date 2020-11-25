package com.sparta.janja;

public class BubbleSortRecursive {

    static void bubbleSort(int[] array, int arrayLength)
            throws ArrayIndexOutOfBoundsException, NullPointerException {

        if (arrayLength < 1) return;
        else {
            if (arrayLength == 1) return;
            for (int i = 0; i < arrayLength - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // swapping
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            bubbleSort(array, arrayLength - 1);
        }
    }
}
