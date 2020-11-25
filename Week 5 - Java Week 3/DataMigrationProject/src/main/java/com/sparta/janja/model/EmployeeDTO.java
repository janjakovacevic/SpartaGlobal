package com.sparta.janja.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class EmployeeDTO {

    private String employeeId;
    private String title;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String emailAddress;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private String salary;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public EmployeeDTO(String[] employeeRecord) {
        employeeId = ((employeeRecord[0]));
        title = (employeeRecord[1]);
        firstName = (employeeRecord[2]);
        middleInitial = (employeeRecord[3]);
        lastName = (employeeRecord[4]);
        gender = (employeeRecord[5]);
        emailAddress = (employeeRecord[6]);
        dateOfBirth = LocalDate.parse(employeeRecord[7], dateTimeFormatter);
        dateOfJoining = LocalDate.parse(employeeRecord[8], dateTimeFormatter);
        salary = (employeeRecord[9]);
    }

    @Override
    public String toString() {
        return (employeeId + "," +
                title + "," +
                firstName + "," +
                middleInitial + "," +
                lastName + "," +
                gender + "," +
                emailAddress + "," +
                dateOfBirth + "," +
                dateOfJoining + "," +
                salary + "\n");
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getSalary() {
        return salary;
    }
}
