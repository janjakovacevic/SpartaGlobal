package com.sparta.janja;

public class MergeSort {

    public static void mergeSort(int[] array) throws ArrayIndexOutOfBoundsException, NullPointerException {

        int arrayLength = array.length;

        if(arrayLength < 2) return;

        int[] leftSubarray = new int[arrayLength / 2];
        int[] rightSubarray = new int[arrayLength - arrayLength / 2];

        divide(array, leftSubarray, rightSubarray);
        mergeSort(leftSubarray);
        mergeSort(rightSubarray);
        merge(array, leftSubarray, rightSubarray);

    }

    // merging 2 arrays
    private static void merge(int[] array, int[] leftSubarray, int[] rightSubarray) {

        int leftSubarrayLength = leftSubarray.length;
        int rightSubarrayLength = rightSubarray.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSubarrayLength && j < rightSubarrayLength){
            if(leftSubarray[i] < rightSubarray[j]){
                array[k++] = leftSubarray[i++];
            }
            else {
                array[k++] = rightSubarray[j++];
            }
        }
        while(i < leftSubarrayLength){
            array[k++] = leftSubarray[i++];
        }
        while(j < rightSubarrayLength) {
            array[k++] = rightSubarray[j++];
        }

    }

    // splitting an array down the middle
    private static void divide(int[] array, int[] leftSubarray, int[] rightSubarray) {

        int arrayLength = array.length;
        int leftSubarrayLength = leftSubarray.length;
        int rightSubarrayLength = arrayLength - leftSubarrayLength;

        System.arraycopy(array, 0, leftSubarray, 0, leftSubarrayLength);

        if (rightSubarrayLength >= 0)
            System.arraycopy(array, leftSubarrayLength, rightSubarray, 0, rightSubarrayLength);

    }
}
