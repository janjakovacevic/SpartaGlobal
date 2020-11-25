package com.sparta.janja;

public class Merger {
    public static int[] mergeSortedArrays(int[] array1, int[] array2){

        int length1 = array1.length, length2 = array2.length;
        int[] array = new int[length1 + length2];

        if(isNotSorted(array1) || isNotSorted(array2)) {
            throw new IllegalArgumentException("Input arrays need to be sorted!");
        }
        else{
            int i = 0, j = 0, k = 0;
            while(i < length1 && j < length2){
                if(array1[i] < array2[j]){
                    array[k++] = array1[i++];
                }
                else {
                    array[k++] = array2[j++];
                }
            }
            while(i < length1){
                array[k++] = array1[i++];
            }
            while(j < length2) {
                array[k++] = array2[j++];
            }
        }
        return array;
    }

    private static boolean isNotSorted(int[] array) {
        if(array.length <= 1) return false;
        else{
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }
}
