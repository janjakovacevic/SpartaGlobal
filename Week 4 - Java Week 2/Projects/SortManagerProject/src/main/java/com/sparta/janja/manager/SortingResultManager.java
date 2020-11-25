package com.sparta.janja.manager;

import com.sparta.janja.logger.LoggerClass;
import com.sparta.janja.sorter.Sorter;
import com.sparta.janja.controller.SortingFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class SortingResultManager {
    // runs algorithm(s) and packs the output in an instance of an object

    private static final int NUMBER_OF_ALGORITHMS = 5;

    private final String algorithmName;
    private final int[] originalArray;
    private final int[] sortedArray;
    private final double sortTime; // milliseconds

    public SortingResultManager(String algorithmName, int[] originalArray, int[] sortedArray, double sortTime) {
        this.algorithmName = algorithmName;
        this.originalArray = originalArray;
        this.sortedArray = sortedArray;
        this.sortTime = sortTime;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
    public int[] getOriginalArray() {
        return originalArray;
    }
    public int[] getSortedArray() {
        return sortedArray;
    }
    public double getSortTime() {
        return sortTime;
    }

    public static SortingResultManager runAlgorithm(int chosenAlgorithm, int[] array){
        int[] unsortedArray = new int[array.length];
        System.arraycopy(array, 0, unsortedArray, 0, array.length);

        LoggerClass.logTrace("Sorting...");

        String algorithmName = SortingFactory.getAlgorithmName(chosenAlgorithm);
        Sorter sorter = SortingFactory.getAlgorithmNumber(chosenAlgorithm);
        double start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(array);
        double end = System.nanoTime();
        double sortTime = (end - start) / 1_000_000;

        LoggerClass.logTrace("Packing Sorting Results for output");

        return new SortingResultManager(algorithmName, unsortedArray, sortedArray, sortTime);
    }

    public static List<SortingResultManager> runAllAlgorithms(int[] array){
        List<SortingResultManager> resultList = new ArrayList<>();

        LoggerClass.logTrace("Running all sorters on the same array");

        for(int i = 1; i <= NUMBER_OF_ALGORITHMS; i++){
            resultList.add(runAlgorithm(i, array));
        }

        LoggerClass.logTrace("Done running all sorters on the same array - time to be displayed");

        return resultList;
    }


}
