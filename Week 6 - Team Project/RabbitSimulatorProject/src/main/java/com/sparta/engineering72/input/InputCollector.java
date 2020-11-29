package com.sparta.engineering72.input;

import com.sparta.engineering72.animal.fox.Fox;
import com.sparta.engineering72.animal.rabbit.Rabbit;
import com.sparta.engineering72.log.Logger;
import com.sparta.engineering72.utility.Sleeper;
import com.sparta.engineering72.view.Display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCollector {

    public static int getReportChoice() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        Display.displayReportChoice();
        Display.displayChoicePrompt();
        do {
            try {
                input = scanner.nextInt();
                if (input < 1 || input > 3) {
                    throw new InputMismatchException("Invalid input");
                }
                return input;
            } catch (InputMismatchException ime) {
                Logger.logError(ime, "Invalid input");
                Display.displayError();
                Sleeper.sleep(100);
            }
        } while (true);
    }

    public static int getApplicationChoice() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        Display.displayApplicationChoice();
        Display.displayChoicePrompt();
        do {
            try {
                input = scanner.nextInt();
                if (input < 1 || input > 2) {
                    throw new InputMismatchException("Invalid input");
                }
                return input;
            } catch (InputMismatchException ime) {
                Logger.logError(ime, "Invalid input");
                Display.displayError();
                Sleeper.sleep(100);
            }
        } while (true);
    }

    public static int getUserInput() {
        int numberOfYears = -1;
        int numberOfMonths = -1;
        int totalMonths;
        do {
            if (numberOfYears < 0) {
                numberOfYears = getTime("Years");
                continue;
            }
            if (numberOfMonths < 0 || isZeroYearsAndNoMonths(numberOfYears, numberOfMonths)) {
                numberOfMonths = getTime("Months");
                continue;
            }
            totalMonths = numberOfMonths+numberOfYears*12;
            return totalMonths;

        } while (true);
    }

    private static boolean isZeroYearsAndNoMonths(int numberOfYears, int numberOfMonths) {
        return numberOfYears == 0 && numberOfMonths <= 0;
    }

    private static int getTime(String timeScale) {
        Scanner input = new Scanner(System.in);
        int numberOfMonths;
        Display.displayEnterNumberOf(timeScale);
        try {
            numberOfMonths = input.nextInt();
            if (numberOfMonths < 0) {
                throw new InputMismatchException("Invalid input");
            }
            return numberOfMonths;
        } catch (InputMismatchException ime) {
            Logger.logError(ime, "Invalid input");
            Display.displayError();
            Sleeper.sleep(100);
        }
        return -1;
    }

    public static int getConstantsChoice() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        Display.displayConstantsChoice();
        Display.displayChoicePrompt();
        do {
            try {
                input = scanner.nextInt();
                if (input < 1 || input > 2) {
                    throw new InputMismatchException("Invalid input");
                }
                return input;
            } catch (InputMismatchException ime) {
                Logger.logError(ime, "Invalid input");
                Display.displayError();
                Sleeper.sleep(100);
            }
        } while (true);
    }

    public static void getConstantsInput(){
        int rabbitMaturityAge = -1;
        int rabbitDeathAge = -1;
        int foxMaturityAge = -1;
        int foxDeathAge = -1;
        do {
            if (rabbitMaturityAge < 0) {
                Display.displayRabbitMaturityAge();
                rabbitMaturityAge = getTime("Months");
                Rabbit.setMaturityAge(rabbitMaturityAge);
                continue;
            }
            if (rabbitDeathAge < 0) {
                Display.displayRabbitDeathAge();
                rabbitDeathAge = getTime("Months");
                Rabbit.setDeathAge(rabbitDeathAge);
                continue;
            }
            if (foxMaturityAge < 0) {
                Display.displayFoxMaturityAge();
                foxMaturityAge = getTime("Months");
                Fox.setMaturityAge(foxMaturityAge);
                continue;
            }
            if (foxDeathAge < 0) {
                Display.displayFoxDeathAge();
                foxDeathAge = getTime("Months");
                Fox.setDeathAge(foxDeathAge);
                continue;
            }
            return;
        } while (true);
    }
}
