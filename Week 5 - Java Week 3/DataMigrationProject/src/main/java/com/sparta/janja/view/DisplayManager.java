package com.sparta.janja.view;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class DisplayManager {

    public static void displayMessage(String message){
        System.out.println(message);
    }

    public static void displaySelection(){
        System.out.println("\n=============================================================================\n"
                + "\n Please select one of the options below: "
                + "\n  1. Select an employee"
                + "\n  2. Delete an employee"
                + "\n  3. Get employee count"
                + "\n  4. Exit the Program"
                + "\n Your Choice: ");
    }

}
