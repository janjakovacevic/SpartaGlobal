package com.sparta.janja;

import com.sparta.janja.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class TestDataTransfer {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final String FILE_PATH = "resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "resources/EmployeeRecordsLarge.csv";

    @Test
    public void testingFirstLine(){
        String[] testString = {"198429","Mrs.","Serafina","I","Bumgarner","F","serafina.bumgarner@exxonmobil.com","9/21/1982","2/1/2008","69294"};
        EmployeeDTO employee = new EmployeeDTO(testString);
        Assertions.assertEquals("198429", employee.getEmployeeId());
        Assertions.assertEquals("Mrs.", employee.getTitle());
        Assertions.assertEquals("Serafina", employee.getFirstName());
        Assertions.assertEquals("I", employee.getMiddleInitial());
        Assertions.assertEquals("Bumgarner", employee.getLastName());
        Assertions.assertEquals("F", employee.getGender());
        Assertions.assertEquals("serafina.bumgarner@exxonmobil.com", employee.getEmailAddress());
        Assertions.assertEquals("9/21/1982", dateTimeFormatter.format(employee.getDateOfBirth()));
        Assertions.assertEquals("2/1/2008", dateTimeFormatter.format(employee.getDateOfJoining()));
        Assertions.assertEquals("69294", employee.getSalary());
    }

    @Test
    public void testingRandomLine(){
        String[] testString = {"647173","Mr.","Milan","F","Krawczyk","M",
                "milan.krawczyk@hotmail.com", "4/4/1980","1/19/2012","123681"};
        EmployeeDTO employee = new EmployeeDTO(testString);
        Assertions.assertEquals("647173", employee.getEmployeeId());
        Assertions.assertEquals("Mr.", employee.getTitle());
        Assertions.assertEquals("Milan", employee.getFirstName());
        Assertions.assertEquals("F", employee.getMiddleInitial());
        Assertions.assertEquals("Krawczyk", employee.getLastName());
        Assertions.assertEquals("M", employee.getGender());
        Assertions.assertEquals("milan.krawczyk@hotmail.com", employee.getEmailAddress());
        Assertions.assertEquals("4/4/1980", dateTimeFormatter.format(employee.getDateOfBirth()));
        Assertions.assertEquals("1/19/2012", dateTimeFormatter.format(employee.getDateOfJoining()));
        Assertions.assertEquals("123681", employee.getSalary());
    }

    @Test
    public void testLastLine() {
        String[] testString = {"133641", "Mr.", "Chas", "F", "Hurdle", "M",
                "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employee = new EmployeeDTO(testString);
        Assertions.assertEquals("133641", employee.getEmployeeId());
        Assertions.assertEquals("Mr.", employee.getTitle());
        Assertions.assertEquals("Chas", employee.getFirstName());
        Assertions.assertEquals("F", employee.getMiddleInitial());
        Assertions.assertEquals("Hurdle", employee.getLastName());
        Assertions.assertEquals("M", employee.getGender());
        Assertions.assertEquals("chas.hurdle@gmail.com", employee.getEmailAddress());
        Assertions.assertEquals("4/20/1995", dateTimeFormatter.format(employee.getDateOfBirth()));
        Assertions.assertEquals("5/28/2016", dateTimeFormatter.format(employee.getDateOfJoining()));
        Assertions.assertEquals("45102", employee.getSalary());
    }

}
