package com.sparta.janja;

public class BubbleSortIterative {

    public static void bubbleSort(int[] array)
            throws ArrayIndexOutOfBoundsException, NullPointerException {
        int length = array.length;

        if (length <= 1) return;
        else {
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        // swapping values
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

}
