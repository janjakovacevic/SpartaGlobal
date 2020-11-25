package com.sparta.janja;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MyLocalDAO {
    // DAO - Data Access Object

    private String URL = "jdbc:mysql://localhost:3306/myLocal";
        // also works: "jdbc:mysql://localhost:3306/myLocal?serverTimezone=GMT"
    private Properties properties = new Properties();
    private Connection connection = null;
    private String selectPersons = "SELECT * FROM Persons";
    private String insertPersons = "INSERT INTO Persons(title, first_name, last_name) \n" +
            "VALUES('Mr', 'Shahid', 'Enayat')";
    private String updatePerson = "UPDATE Persons\n" +
            "SET first_name = 'Svilen'" +
            "WHERE first_name = 'Saleh'";
    private String deletePerson = "DELETE FROM Persons WHERE personId = ? AND first_name = ?";

    private Connection connectToDatabase(){
        try {
            properties.load(new FileReader("resources/login.properties"));
            connection = DriverManager.getConnection(URL, properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readPersons(){
        Statement statement = null;
        try {
            statement = connectToDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery(selectPersons);
            if(resultSet != null){
                while (resultSet.next()){
                    Printer.printInt(resultSet.getInt(1));
                    Printer.printString(resultSet.getString(2));
                    Printer.printString(resultSet.getString(3));
                    Printer.printString(resultSet.getString(4));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addPersons(){
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertPersons);
            int hasRun = preparedStatement.executeUpdate();
            if(hasRun == 1){
                Printer.printString("Insert is successful");
            } else{
                Printer.printString("The person could not be persisted");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatePersons(){
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(updatePerson);
            int hasRun = preparedStatement.executeUpdate();
            if(hasRun == 1){
                Printer.printString("Update is successful");
            } else{
                Printer.printString("The person could not be persisted");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removePersons(int personId, String first_name){
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(deletePerson);
            preparedStatement.setInt(1, personId);
            preparedStatement.setString(2, first_name);
            int hasRun = preparedStatement.executeUpdate();
            if(hasRun == 1){
                Printer.printString("Delete is successful");
            } else{
                Printer.printString("The deletion could not be persisted");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
