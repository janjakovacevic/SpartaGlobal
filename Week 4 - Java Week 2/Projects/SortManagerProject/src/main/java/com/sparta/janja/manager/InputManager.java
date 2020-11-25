package com.sparta.janja.manager;

import com.sparta.janja.exceptions.ChoiceOutOfBoundsException;
import com.sparta.janja.exceptions.ExceptionConstants;
import com.sparta.janja.exceptions.SortManagerInputException;
import com.sparta.janja.logger.LoggerClass;
import com.sparta.janja.views.DisplayManager;

import java.util.*;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class InputManager {
    // takes input from the user (algorithm and array length choice)

    private static final int EXIT = 7;
    public static final int MAX_ARRAY_SIZE = 1_000;

    public static int scanForChosenAlgorithm(){

        LoggerClass.logTrace("Scanning for Algorithm Number");

        Scanner scanner = new Scanner(System.in);
        int chosenAlgorithm;
        do {
            DisplayManager.displayMessage
                    ("\n==============================================================\n"
                            + "\n Sort Manager - Please select your desired sorting algorithm"
                            + "\n  1. Bubble Sort"
                            + "\n  2. Merge Sort"
                            + "\n  3. Binary Sort (ascending order)"
                            + "\n  4. Binary Sort (descending order)"
                            + "\n  5. Quick Sort"
                            + "\n  6. Display Algorithms' Compared Speeds"
                            + "\n  7. Exit Sort Manager"
                            + "\n Your Choice: ");

            try {
                chosenAlgorithm = scanner.nextInt();
                if (chosenAlgorithm < 1 || chosenAlgorithm > EXIT) {
                    throw new ChoiceOutOfBoundsException("Your chosen input is out of bounds. " +
                            "Please choose a number between 1 and " + EXIT);
                }
            } catch (InputMismatchException ime) {
                chosenAlgorithm = 0;
                LoggerClass.logError(ExceptionConstants.NON_INTEGER_INPUT);
                scanner.nextLine();
            } catch (Exception e) {
                chosenAlgorithm = 0;
                DisplayManager.displayMessage(e.getMessage() + " caused by " + e.getCause());
            }
        } while (chosenAlgorithm == 0);

        return chosenAlgorithm;
    }

    public static int scanForChosenArrayLength(){

        LoggerClass.logTrace("Scanning for Array Length");

        Scanner scanner = new Scanner(System.in);
        int chosenArrayLength;

        do{
            DisplayManager.displayMessage(
                    "--------------------------------------------------------------------------------------"
                    + "\nHow long would you like your array to be? " +
                    "You can pick any number between 1 and " + MAX_ARRAY_SIZE +
                    "\n Your Choice of Array Length: ");

            try{
                chosenArrayLength = scanner.nextInt();
                if (chosenArrayLength == 0) {
                    throw new SortManagerInputException(ExceptionConstants.ARRAY_LENGTH_ZERO);
                } else if (chosenArrayLength   < 0) {
                    throw new SortManagerInputException(ExceptionConstants.ARRAY_LENGTH_NEGATIVE);
                }
            } catch (NegativeArraySizeException nase) {
                chosenArrayLength = 0;
                LoggerClass.logError(ExceptionConstants.ARRAY_LENGTH_NEGATIVE);
            } catch (InputMismatchException ime) {
                chosenArrayLength = 0;
                LoggerClass.logError(ExceptionConstants.NON_INTEGER_INPUT);
                scanner.nextLine();
            } catch (Exception e) {
                chosenArrayLength = 0;
                LoggerClass.logError(e.getMessage() + " caused by " + e.getCause());
            }
            chosenArrayLength = Math.min(chosenArrayLength, MAX_ARRAY_SIZE);

        } while (chosenArrayLength < 1);

        return chosenArrayLength;
    }



}
