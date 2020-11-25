package com.sparta.janja.sorter;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class QuickSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    private void quickSort(int[] array, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        // calculate pivot number (here: middle number)
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        // divide into two arrays
        while (i <= j) {

            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            if (i <= j) {
                // swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // move index to next position on both sides
                i++;
                j--;
            }
        }

        // call quickSort() method recursively
        if (lowerIndex < j) quickSort(array, lowerIndex, j);
        if (i < higherIndex) quickSort(array, i, higherIndex);
    }

}
