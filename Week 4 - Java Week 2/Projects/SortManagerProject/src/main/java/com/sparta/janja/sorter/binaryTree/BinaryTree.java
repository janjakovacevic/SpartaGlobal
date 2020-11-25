package com.sparta.janja.sorter.binaryTree;

import com.sparta.janja.exceptions.ChildNotFoundException;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public interface BinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element);

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();

}
