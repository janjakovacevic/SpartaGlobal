package com.sparta.janja.controller;

import com.sparta.janja.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class EmployeeFileReaderThreaded {

    /**
     * Time taken with threads on a file of 10.000 lines: ~1.46 seconds
     * Time taken with threads on a file of 65.000 lines: ~3.30 seconds
     */

    static ArrayList<Thread> threads = new ArrayList();
    private static HashMap<String, EmployeeDTO> threadedEmployeeRecords = new HashMap<>();
    private static final HashMap<String, EmployeeDTO> employeeRecords = new HashMap<>();
    private static final int NUMBER_OF_THREADS = 25;


    public static void readFromCSVAndWriteToDatabaseThreaded(String filePath) {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            long entryCount = Files.lines(Paths.get(filePath)).count(); // move?
            bufferedReader.readLine(); // skips the first line (column names)
            while ((line = bufferedReader.readLine()) != null) {
                populateHashMaps(line);
                if(threadedEmployeeRecords.size() > entryCount / NUMBER_OF_THREADS){
                    createNewThreadAndPersistToDatabase(threadedEmployeeRecords);
                    threadedEmployeeRecords = new HashMap<>();
                }
            }
            createNewThreadAndPersistToDatabase(threadedEmployeeRecords);
            killThreads();
        } catch (IOException e) {
            LoggerClass.logError("Reading CSV failed: " + e.getMessage());
        } catch (NullPointerException e) {
            LoggerClass.logError("Thread Null Pointer: " + e.getMessage());
        }
    }

    private static void populateHashMaps(String line){
        String[] record = line.trim().split(",");
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        if(DataValidation.isRecordValid(record)) {
            if(!employeeRecords.containsKey(record[0])) {
                employeeRecords.put(record[0], employeeDTO);
                threadedEmployeeRecords.put(record[0], employeeDTO);
            } else{
                EmployeeFileWriter.writeEntryToFile("resources/duplicateValues.csv", employeeDTO, "duplicate");
            }
        } else{
            EmployeeFileWriter.writeEntryToFile("resources/invalidValues.csv", employeeDTO, "invalid");
        }
    }

    private static void createNewThreadAndPersistToDatabase(HashMap<String, EmployeeDTO> employeeHashMap){
        Object lock = new Object();
        Runnable runnable = () -> {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            synchronized (lock) {
                employeeDAO.persistToDB(employeeHashMap);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        threads.add(thread);
    }

    private static void killThreads(){
        while (threads.size() > 0){
            threads.removeIf((thread -> !thread.isAlive()));
        }
    }
}
