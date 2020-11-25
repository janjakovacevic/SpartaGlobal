package com.sparta.janja.controller;

import com.sparta.janja.model.LoggerClass;
import com.sparta.janja.model.EmployeeDAO;
import com.sparta.janja.view.DisplayManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class EmployeeManager {

    private static final String FILE_PATH = "resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "resources/EmployeeRecordsLarge.csv";
    private static final String DUPLICATES_FILE_PATH = "resources/duplicateValues.csv";
    private static final String INVALID_FILE_PATH = "resources/invalidValues.csv";

    public void initialize() {
        try {
            resetDBAndFiles();
            long start = System.nanoTime();
            readEmployeesInitialize();
            long end = System.nanoTime();
            DisplayManager.displayMessage("\n=============================================================================\n\n"
                    + " Data read from CSV file and imported into a database in " + (end - start)/1_000_000_000.0 + " seconds");
        } catch(Exception e){
            LoggerClass.logError("Initialize failed: " + e.getMessage() );
        }
    }

    public void readEmployeesInitialize() {
        EmployeeFileReaderThreaded.readFromCSVAndWriteToDatabaseThreaded(FILE_PATH_LARGE);
    }

    public void readEmployeesThreaded(String filePath) {
        EmployeeFileReaderThreaded.readFromCSVAndWriteToDatabaseThreaded(filePath);
    }

    public void readEmployeesNonThreaded(String filePath) { EmployeeFileReader.readFromCSVAndWriteToDatabase(filePath);}

    public void selectEmployee() throws InputMismatchException, NullPointerException{
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.searchById(InputManager.getInt());
        employeeDAO.closeConnection();
    }

    public void deleteEmployee() throws InputMismatchException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteById(InputManager.getInt());
        employeeDAO.closeConnection();
    }

    public void countEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int rows = employeeDAO.countRows();
        employeeDAO.closeConnection();
    }

    public void resetDBAndFiles(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        try {
            employeeDAO.createNewTable();
            Files.deleteIfExists(Paths.get(DUPLICATES_FILE_PATH));
            Files.deleteIfExists(Paths.get(INVALID_FILE_PATH));
        } catch (IOException e) {
            LoggerClass.logError("Couldn't reset the DB/extra files: " + e.getMessage());
        } finally {
            employeeDAO.closeConnection();
        }
    }

}
