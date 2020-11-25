package com.sparta.janja.controller;

import com.sparta.janja.logger.LoggerClass;
import com.sparta.janja.manager.ArrayGenerator;
import com.sparta.janja.manager.InputManager;
import com.sparta.janja.manager.SortingResultManager;
import com.sparta.janja.views.DisplayManager;

import java.util.List;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class SortManagerController {
    // makes calls to all methods necessary to run SortManager

    private final static int COMPARE_ALL_ALGORITHMS_PERFORMANCE = 6;
    private final static int EXIT_PROGRAM = 7;

    public static void start() {

        LoggerClass.logTrace("Starting CLI");

        int chosenAlgorithm;
        int chosenArrayLength = InputManager.MAX_ARRAY_SIZE;
        int[] generatedArray;

        try {
            LoggerClass.logTrace("Starting do-while loop inside try-catch block in SortManagerRunner");
            do {
                chosenAlgorithm = InputManager.scanForChosenAlgorithm();

                if (chosenAlgorithm != EXIT_PROGRAM) {
                    chosenArrayLength = InputManager.scanForChosenArrayLength();
                    generatedArray = ArrayGenerator.generatingRandomArray(chosenArrayLength);

                    if (chosenAlgorithm == COMPARE_ALL_ALGORITHMS_PERFORMANCE) {
                        List<SortingResultManager> algorithmTimesList = SortingResultManager.runAllAlgorithms(generatedArray);
                        DisplayManager.displayAllAlgorithmTimes(algorithmTimesList);
                    } else {
                        SortingResultManager sortingResultManager = SortingResultManager.runAlgorithm(chosenAlgorithm, generatedArray);
                        DisplayManager.displaySortingResults(sortingResultManager);
                    }
                }

                DisplayManager.displayEndOfARequest();

            } while (chosenAlgorithm != EXIT_PROGRAM);
            LoggerClass.logTrace("Ending do-while loop inside try-catch block in SortManagerRunner");
        } catch (IndexOutOfBoundsException e){
            LoggerClass.logError(e.getMessage());
        } catch (Exception e){
            LoggerClass.logError(e.getMessage() + " caused by " + e.getCause());
            System.exit(1);
        }
        LoggerClass.logTrace("Exiting CLI");
    }

}
