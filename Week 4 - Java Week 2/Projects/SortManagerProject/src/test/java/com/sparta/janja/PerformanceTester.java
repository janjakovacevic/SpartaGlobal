package com.sparta.janja;

import com.sparta.janja.manager.ArrayGenerator;
import com.sparta.janja.manager.SortingResultManager;
import com.sparta.janja.views.DisplayManager;
import org.junit.jupiter.api.Test;

/**
 * @author janjakovacevic on 03/11/2020.
 * @project SortManagerProject
 */

public class PerformanceTester {

    int[] randomTestArray = ArrayGenerator.generatingRandomArray(1000);

    @Test
    public void testBubbleSortPerformance(){
        DisplayManager.displayMessage("Bubble Sort - completed in: " +
                SortingResultManager.runAlgorithm(1, randomTestArray).getSortTime() + " milliseconds");
    }

    @Test
    public void testMergeSortPerformance(){
        DisplayManager.displayMessage("Merge Sort - completed in: " +
                SortingResultManager.runAlgorithm(2, randomTestArray).getSortTime() + " milliseconds");
    }
    @Test
    public void testBinarySortAscendingPerformance(){
        DisplayManager.displayMessage("Binary Sort Ascending - completed in: " +
                SortingResultManager.runAlgorithm(3, randomTestArray).getSortTime() + " milliseconds");
    }
    @Test
    public void testBinarySortDescendingPerformance(){
        DisplayManager.displayMessage("Binary Sort Descending - completed in: " +
                SortingResultManager.runAlgorithm(4, randomTestArray).getSortTime() + " milliseconds");
    }
    @Test
    public void testQuickSortPerformance(){
        DisplayManager.displayMessage("Quick Sort - completed in: " +
                SortingResultManager.runAlgorithm(5, randomTestArray).getSortTime() + " milliseconds");
    }

}
