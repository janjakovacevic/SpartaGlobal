package com.sparta.janja;

import com.sparta.janja.sorter.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author janjakovacevic on 18/10/2020.
 * @project SortManagerProject
 */
public class QuickSortTester {

    QuickSort quickSort = new QuickSort();

    @Test
    @DisplayName("Testing Merge Sort")
    public void testQuickSort(){
        int[] array1 = {11, 63, 40, 39, 88, 33};  // random
        int[] array2 = {58, 57, 56, 55, 54, 53};  // descending (reverse) order
        int[] array3 = {113, 114, 115, 116, 117, 118};  // ascending (correct) order
        int[] array4 = {50, 20, 80, 20, 80, 50};  // few unique value (not realistic input)
        int[] array5 = {-43, 13, -5, 0, 109, 8};  // negative value (not realistic input)

        int[] array1Sorted = {11, 33, 39, 40, 63, 88};
        int[] array2Sorted = {53, 54, 55, 56, 57, 58};
        int[] array3Sorted = {113, 114, 115, 116, 117, 118};
        int[] array4Sorted = {20, 20, 50, 50, 80, 80};
        int[] array5Sorted = {-43, -5, 0, 8, 13, 109};

        Assertions.assertArrayEquals(array1Sorted, quickSort.sortArray(array1));
        Assertions.assertArrayEquals(array2Sorted, quickSort.sortArray(array2));
        Assertions.assertArrayEquals(array3Sorted, quickSort.sortArray(array3));
        Assertions.assertArrayEquals(array4Sorted, quickSort.sortArray(array4));
        Assertions.assertArrayEquals(array5Sorted, quickSort.sortArray(array5));
    }
}
