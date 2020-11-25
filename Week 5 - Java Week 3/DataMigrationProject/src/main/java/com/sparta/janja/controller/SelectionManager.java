package com.sparta.janja.controller;

import com.sparta.janja.model.LoggerClass;
import com.sparta.janja.view.DisplayManager;

import java.util.InputMismatchException;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class SelectionManager {
    public static void startSelection() {
        boolean done = false;
        while(!done){
            boolean choiceMade = false;
            DisplayManager.displaySelection();
            int userChoice = 0;
            do {
                try {
                    userChoice = InputManager.getInt();
                    if(userChoice >= 1 && userChoice <= 4){
                        choiceMade = true;
                    } else{
                        DisplayManager.displayMessage("Please select one of the options above");
                    }
                } catch (InputMismatchException e){
                    LoggerClass.logError(e.getMessage());
                    DisplayManager.displayMessage("Please pick a number between 1 and 4");
                    InputManager.getString();
                } catch (Exception e){
                    LoggerClass.logError(e.getMessage());
                    InputManager.getString();
                }
            } while(!choiceMade);

            switch (userChoice){
                case 1:
                    selectEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    countEmployees();
                    break;
                case 4:
                    done = true;
                    break;
            }
        }
    }

    private static void selectEmployee(){
        EmployeeManager employeeManager = new EmployeeManager();
        boolean done = false;
        do {
            try {
                DisplayManager.displayMessage("Please enter an employee ID: ");
                employeeManager.selectEmployee();
                done = true;
            } catch (InputMismatchException | NullPointerException e){
                LoggerClass.logError(e.getMessage());
            }
        } while(!done);
    }

    private static void deleteEmployee(){
        EmployeeManager employeeManager = new EmployeeManager();
        boolean done = false;
        do {
            try {
                DisplayManager.displayMessage("Please enter an employee ID: ");
                employeeManager.deleteEmployee();
                done = true;
            } catch (InputMismatchException e){
                LoggerClass.logError(e.getMessage());
            }
        } while(!done);
    }

    private static void countEmployees(){
        EmployeeManager employeeManager = new EmployeeManager();
        boolean done = false;
        do {
            employeeManager.countEmployees();
            done = true;
        } while(!done);
    }



}
