package com.sparta.janja.sorter;

import com.sparta.janja.sorter.binaryTree.BinaryTreeImplementation;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class BinarySortDescending implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTreeImplementation binaryTree = new BinaryTreeImplementation(arrayToSort);
        return binaryTree.getSortedTreeDesc();
    }
}
