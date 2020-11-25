package com.sparta.janja.sorter;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        bubbleSort(arrayToSort);
        return arrayToSort;
    }

    private static void bubbleSort(int[] array)
            throws ArrayIndexOutOfBoundsException {
        int length = array.length;
        if(length < 1) return;
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
