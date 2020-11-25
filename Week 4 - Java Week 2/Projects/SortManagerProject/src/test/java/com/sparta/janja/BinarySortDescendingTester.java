package com.sparta.janja;

import com.sparta.janja.sorter.BinarySortDescending;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySortDescendingTester {
    BinarySortDescending binarySortDescending = new BinarySortDescending();

    @Test
    @DisplayName("Testing Binary Sort - Descending")
    public void testBinarySortDescending(){
        int[] array1 = {11, 63, 40, 39, 88, 33};  // random
        int[] array2 = {58, 57, 56, 55, 54, 53};  // descending (correct) order
        int[] array3 = {113, 114, 115, 116, 117, 118};  // ascending (reverse) order
        int[] array4 = {50, 20, 80, 20, 80, 50};  // few unique value (not realistic input)
        int[] array5 = {-43, 13, -5, 0, 109, 8};  // negative value (not realistic input)

        int[] array1Sorted = {88, 63, 50, 39, 33, 11};
        int[] array2Sorted = {58, 57, 56, 55, 54, 53};
        int[] array3Sorted = {118, 117, 116, 115, 114, 113};
        int[] array4Sorted = {80, 80, 50, 50, 20, 20};
        int[] array5Sorted = {109, 13, 8, 0, -5 -43};

        Assertions.assertArrayEquals(array1Sorted, binarySortDescending.sortArray(array1));
        Assertions.assertArrayEquals(array2Sorted, binarySortDescending.sortArray(array2));
        Assertions.assertArrayEquals(array3Sorted, binarySortDescending.sortArray(array3));
        Assertions.assertArrayEquals(array4Sorted, binarySortDescending.sortArray(array4));
        Assertions.assertArrayEquals(array5Sorted, binarySortDescending.sortArray(array5));
    }
}
