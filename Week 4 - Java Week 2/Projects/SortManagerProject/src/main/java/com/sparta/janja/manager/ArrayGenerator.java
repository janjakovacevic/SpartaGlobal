package com.sparta.janja.manager;

import com.sparta.janja.logger.LoggerClass;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static com.sparta.janja.manager.InputManager.MAX_ARRAY_SIZE;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */
public class ArrayGenerator {
    // generates a random array of length specified by the user

    public static int[] generatingRandomArray(int chosenArrayLength){

        LoggerClass.logTrace("Generating a Random Array");

        Random random = new Random();

        // using a set ensures no duplicates are generated
        Set<Integer> generated = new LinkedHashSet<>();
        while(generated.size() < chosenArrayLength){
            Integer next = random.nextInt(MAX_ARRAY_SIZE);
            generated.add(next);
        }

        // copy set into an array that is to be sorted
        int[] randomArray = new int[chosenArrayLength];
        int index = 0;
        for(int number : generated) {
            randomArray[index++] = number;
        }

        return randomArray;
    }


}
