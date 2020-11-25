package com.sparta.janja.controller;


import com.sparta.janja.sorter.*;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class SortingFactory {
    public static Sorter getAlgorithmNumber(int algorithmNumber){
        switch(algorithmNumber){
            case 1:
                return new BubbleSort();
            case 2:
                return new MergeSort();
            case 3:
                return new BinarySortAscending();
            case 4:
                return new BinarySortDescending();
            case 5:
            default:
                return new QuickSort();
        }
    }

    public static String getAlgorithmName(int algorithmNumber){
        switch(algorithmNumber){
            case 1:
                return "BUBBLE SORT";
            case 2:
                return "MERGE SORT";
            case 3:
                return "BINARY SORT (ascending order)";
            case 4:
                return "BINARY SORT (descending order)";
            case 5:
            default:
                return "QUICK SORT";
        }
    }

}
