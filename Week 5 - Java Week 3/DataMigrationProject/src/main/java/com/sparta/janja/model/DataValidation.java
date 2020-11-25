package com.sparta.janja.model;

import java.text.SimpleDateFormat;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class DataValidation {

    private static final int NUMBER_OF_COLUMNS = 10;

    public static boolean isRecordValid(String[] employeeRecord){

        return (employeeRecord.length == NUMBER_OF_COLUMNS &&
                isEmployeeIdValid(employeeRecord[0]) &&
                isTitleValid(employeeRecord[1]) &&
                isNameValid(employeeRecord[2]) &&
                isMiddleInitialValid(employeeRecord[3]) &&
                isNameValid(employeeRecord[4]) &&
                isGenderValid(employeeRecord[5]) &&
                isEmailValid(employeeRecord[6]) &&
                isDateValid(employeeRecord[7]) &&
                isDateValid(employeeRecord[8]) &&
                isSalaryValid(employeeRecord[9]));
    }

    private static boolean isEmployeeIdValid(String employeeId){
        try {
            Integer.parseInt(employeeId);
        } catch (NumberFormatException e) {
            LoggerClass.logError("Employee ID is not an integer data type");
            return false;
        }
        return true;
    }

    private static boolean isTitleValid(String title){
        String[] titles = new String[] {"Prof.", "Mrs.", "Mr.", "Ms.", "Dr.", "Drs.", "Hon."};
        for (String honoraryTitle : titles) {
            if(honoraryTitle.equals(title)) return true;
        }
        return false;
    }

    private static boolean isNameValid(String name){
        return (name.matches("^[a-zA-Z]*$"));
    }

    private static boolean isMiddleInitialValid(String middleInitial){
        return (middleInitial.matches("^[A-Z]") || middleInitial.length() != 1);
    }

    private static boolean isGenderValid(String gender){
        return gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("M");
    }

    private static boolean isEmailValid(String email){
        return email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
    }

    private static boolean isDateValid(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        try{
            dateFormat.parse(date);
        } catch(Exception e){
            LoggerClass.logError("Date is not a valid date type");
            return false;
        }
        return true;
    }

    private static boolean isSalaryValid(String salary){
        try {
            Integer.parseInt(salary);
        } catch (NumberFormatException e) {
            LoggerClass.logError("Salary is not an integer data type");
            return false;
        }
        return true;
    }


}
