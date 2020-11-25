package com.sparta.janja.controller;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class Starter {

    public static void start(){
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.initialize();
        SelectionManager.startSelection();
    }

}
