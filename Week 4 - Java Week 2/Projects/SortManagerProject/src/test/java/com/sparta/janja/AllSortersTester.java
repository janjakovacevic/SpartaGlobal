package com.sparta.janja;

import com.sparta.janja.manager.ArrayGenerator;
import com.sparta.janja.sorter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.apache.commons.lang3.ArrayUtils.reverse;

public class AllSortersTester {

     Sorter bubbleSorter = new BubbleSort();
     Sorter mergeSorter = new MergeSort();
     Sorter binarySorterAscending = new BinarySortAscending();
     Sorter binarySorterDescending = new BinarySortDescending();
     Sorter quickSorter = new QuickSort();

     @Test
     @DisplayName("Testing all sorting algorithms together on an array of size 1000")
     public void testAllSorters() {

        int[] randomArray = ArrayGenerator.generatingRandomArray(1000);
        int[] correctArray = Arrays.copyOf(randomArray, randomArray.length);
        int[] correctArrayReversed = Arrays.copyOf(randomArray, randomArray.length);
         // correct array
         Arrays.sort(correctArray);

         // correct array just reversed (for binary sort in descending order)
         Arrays.sort(correctArrayReversed);
         reverse(correctArrayReversed);

         // test against the built-in array sorting method
         Assertions.assertArrayEquals(correctArray, bubbleSorter.sortArray(randomArray));
         Assertions.assertArrayEquals(correctArray, mergeSorter.sortArray(randomArray));
         Assertions.assertArrayEquals(correctArrayReversed, binarySorterDescending.sortArray(randomArray));
         Assertions.assertArrayEquals(correctArray, binarySorterAscending.sortArray(randomArray));
         Assertions.assertArrayEquals(correctArray, quickSorter.sortArray(randomArray));
     }

}
