package com.sparta.janja.sorter;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class MergeSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        mergeSort(arrayToSort);
        return arrayToSort;
    }

    public static void mergeSort(int[] array) throws ArrayIndexOutOfBoundsException, NullPointerException {

        int arrayLength = array.length;
        if(arrayLength < 2) return;

        // dividing the array
        int[] leftSubarray = new int[arrayLength / 2];
        int[] rightSubarray = new int[arrayLength - arrayLength / 2];
        System.arraycopy(array, 0, leftSubarray, 0, arrayLength / 2);
        System.arraycopy(array, arrayLength / 2, rightSubarray, 0, arrayLength - arrayLength / 2);

        mergeSort(leftSubarray);
        mergeSort(rightSubarray);
        merge(array, leftSubarray, rightSubarray);

    }

    // merging 2 arrays
    private static void merge(int[] array, int[] leftSubarray, int[] rightSubarray) {

        int i = 0, j = 0, k = 0;

        while(i < leftSubarray.length && j < rightSubarray.length){
            if(leftSubarray[i] < rightSubarray[j]){
                array[k++] = leftSubarray[i++];
            }
            else {
                array[k++] = rightSubarray[j++];
            }
        }
        while(i < leftSubarray.length){
            array[k++] = leftSubarray[i++];
        }
        while(j < rightSubarray.length) {
            array[k++] = rightSubarray[j++];
        }

    }

}

