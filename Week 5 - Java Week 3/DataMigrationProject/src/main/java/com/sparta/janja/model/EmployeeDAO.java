package com.sparta.janja.model;

import com.sparta.janja.view.DisplayManager;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class EmployeeDAO {

    private static final String URL = "jdbc:mysql://";

    private static final String INSERT_STATEMENT = "INSERT INTO myLocal.EmployeeRecords " +
            "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM EmployeeRecords";
    private static final String DELETE_STATEMENT = "DELETE FROM EmployeeRecords WHERE employeeId = ?";
    private static final String SELECT_EMPLOYEE  = "SELECT * FROM EmployeeRecords WHERE employeeId = ";
//    private static final String TRUNCATE = "TRUNCATE myLocal.EmployeeRecords";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS EmployeeRecords";
    private static final String CREATE_TABLE = "CREATE TABLE EmployeeRecords(\n" +
                                            "    employeeId INT,\n" +
                                            "    title VARCHAR(10),\n" +
                                            "    first_name VARCHAR(45),\n" +
                                            "    middle_initial VARCHAR(1),\n" +
                                            "    last_name VARCHAR(45),\n" +
                                            "    gender VARCHAR(1),\n" +
                                            "    email_address VARCHAR(50),\n" +
                                            "    date_of_birth DATE,\n" +
                                            "    date_of_joining DATE,\n" +
                                            "    salary INT,\n" +
                                            "    PRIMARY KEY (employeeId)\n" +
                                            ")";

    private Connection connection = null;

    public void openConnection(){
        try {
            connection = DriverManager.getConnection((URL + System.getenv("java_sql_db")),
                    System.getenv("java_sql_db_username"), System.getenv("java_sql_db_password"));
        } catch (SQLException throwables) {
            LoggerClass.logError("Cannot open connection: " + throwables.getMessage());
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException | NullPointerException throwables) {
            LoggerClass.logError("Cannot close connection: " + throwables.getMessage());
        }
    }

    public void persistToDB(HashMap<String, EmployeeDTO> employeeRecords) {
        if(connection == null) openConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)){
            int tracker = 1;
            connection.setAutoCommit(false);
            for (EmployeeDTO employee : employeeRecords.values()) {
                preparedStatement.setString(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getTitle());
                preparedStatement.setString(3, employee.getFirstName());
                preparedStatement.setString(4, employee.getMiddleInitial());
                preparedStatement.setString(5, employee.getLastName());
                preparedStatement.setString(6, employee.getGender());
                preparedStatement.setString(7, employee.getEmailAddress());
                preparedStatement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                preparedStatement.setString(10, employee.getSalary());
                preparedStatement.addBatch();
                if(tracker == employeeRecords.size()) {
                    int[] batchExecuted = preparedStatement.executeBatch();
                    LoggerClass.logTrace("Data persisted to the db");
                    connection.commit();
                }
                tracker++;
            }
        } catch (SQLException e) {
            LoggerClass.logError("persistToDB: " + e.getMessage());
        }
    }

    public int countRows() {
        if(connection == null) openConnection();
        long startTime = System.nanoTime();
        int count = 0;
        try(Statement statement = connection.createStatement()){
            statement.executeQuery(COUNT_ROWS);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            count = Integer.parseInt(resultSet.getString(1));
            statement.close();
        } catch (SQLException e){
            LoggerClass.logError("Rows couldn't be counted: " + e.getMessage());
        } finally {
            double totalTime = (System.nanoTime() - startTime)/1_000_000_000.0;
            DisplayManager.displayMessage("Operation performed in " + totalTime + " milliseconds");
            DisplayManager.displayMessage("Total Number Of Employees :: " + count);
        }
        return count;
    }

    public void deleteById(int employeeId){
        if(connection == null) openConnection();
        long startTime = System.nanoTime();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT)){
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LoggerClass.logError("Employee couldn't be deleted from the database: " + e.getMessage());
        } finally {
            closeConnection();
            double totalTime = (System.nanoTime() - startTime) / 1_000_000.0;
            DisplayManager.displayMessage("Deletion done in " + totalTime + " milliseconds");
            DisplayManager.displayMessage("Employee deleted from the database.");
        }
    }

    public void searchById(int employeeId) throws NullPointerException{
        if (connection == null) openConnection();
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        long startTime = System.nanoTime();
        EmployeeDTO employee = null;
        try (Statement statement = connection.createStatement()){
            statement.executeQuery(SELECT_EMPLOYEE + employeeId);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            String[] employeeDetails = {"" + resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    dateFormat.format(resultSet.getDate(8)),
                    dateFormat.format(resultSet.getDate(9)),
                    Integer.toString(resultSet.getInt(10))};
            employee = new EmployeeDTO(employeeDetails);
        } catch (SQLException e) {
            LoggerClass.logError(e.getMessage());
        } finally {
            closeConnection();
            double totalTime = (System.nanoTime() - startTime) / 1_000_000.0;
            if(employee == null) DisplayManager.displayMessage("Employee with ID " + employeeId + " does not exist.");
            DisplayManager.displayMessage("Lookup done in " + totalTime + " milliseconds\n" +
                            "Employee details: " + employee.toString().trim());
        }
    }

    // dropping then creating a new table
    public void createNewTable(){
        if(connection == null) openConnection();
        try {
            dropTable();
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void dropTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate(DROP_TABLE);
        statement.close();
    }

    private void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeLargeUpdate(CREATE_TABLE);
        statement.close();
    }


}
