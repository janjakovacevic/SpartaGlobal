package com.sparta.janja;

import com.sparta.janja.controller.EmployeeManager;
import com.sparta.janja.view.DisplayManager;
import org.junit.jupiter.api.Test;

public class TestNonThreadedPerformance {
    private static final String FILE_PATH = "resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "resources/EmployeeRecordsLarge.csv";

    private double timeDataPersistenceNonThreaded(String filePath){
        EmployeeManager employeeManager = new EmployeeManager();
        long start = System.nanoTime();
        employeeManager.resetDBAndFiles();
        employeeManager.readEmployeesNonThreaded(filePath);
        long end = System.nanoTime();

        return (end - start)/1_000_000_000.0;
    }

    @Test
    public void testNonThreadedPerformanceTime(){
        DisplayManager.displayMessage("Completed in: " + timeDataPersistenceNonThreaded(FILE_PATH) + " seconds");
    }

    @Test
    public void testNonThreadedPerformanceTimeLargeDataSet(){
        DisplayManager.displayMessage("Completed in: " + timeDataPersistenceNonThreaded(FILE_PATH_LARGE) + " seconds");
    }

}
