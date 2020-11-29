package com.sparta.engineering72.view;

import com.sparta.engineering72.animal.fox.Fox;
import com.sparta.engineering72.animal.rabbit.Rabbit;
import com.sparta.engineering72.utility.ReportPacker;

import java.io.BufferedWriter;
import java.io.IOException;

public class Display {

    public static void display(ReportPacker reportPacker, int time, BufferedWriter bfTxt) throws IOException {
        Printer.printReportToConsole(reportPacker, time);
        TextFileWriter.writeReportToFile(bfTxt, reportPacker, time);
    }

    public static void displayReportChoice(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Please choose how you want the report to be displayed:");
        System.out.println("    Enter 1 for a single report at the end of the simulation");
        System.out.println("    Enter 2 for a month-by-month breakdown of the simulation");
        System.out.println("    Enter 3 for no report (data will be saved to a JSON file)");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void displayApplicationChoice() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Please choose how you want to run the application:");
        System.out.println("    Enter 1 for a console");
        System.out.println("    Enter 2 for a GUI");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void displayStartMessage() {
        System.out.println("\nWELCOME TO THE RABBIT SIMULATOR");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("All required user inputs should be entered in the console when prompted");
        System.out.println("The final report from the simulation will also be displayed in the console");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Default values:");
        System.out.println("    Rabbit Maturity Age: " + Rabbit.getMaturityAge() + " months");
        System.out.println("    Rabbit Death Age: " + Rabbit.getDeathAge() + " months");
        System.out.println("    Fox Maturity Age: " + Fox.getMaturityAge() + " months");
        System.out.println("    Fox Death Age: " + Fox.getDeathAge() + " months");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void displaySimulationStart(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("The Simulation starts off with 1 male and 1 female rabbit...");
        System.out.println("... and 1 male and 1 female fox!");
        System.out.println("The Simulation is starting now...");
        System.out.println("-------------------------------------------------------------------------------\n");
    }

    public static void displaySimulationCompleted(){
        System.out.println("Simulation completed.");
        System.out.println("-------------------------------------------------------------------------------\n");
    }

    public static void displayError() {
        System.err.println("Invalid input. Please enter a number with characters ranging from [0-9].");
    }

    public static void displayEnterNumberOf(String timeScale) {
        System.out.print("Enter a number of " + timeScale.toLowerCase() + ": ");
    }

    public static void displayConstantsChoice(){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Please choose whether you wish to change the default constants:");
        System.out.println("    Enter 1 for default constants");
        System.out.println("    Enter 2 to change the constants");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void displayFoxMaturityAge(){
        System.out.println("Please enter the Fox Maturity Age in Months");
    }
    public static void displayRabbitMaturityAge(){
        System.out.println("Please enter the Rabbit Maturity Age in Months");
    }
    public static void displayFoxDeathAge(){
        System.out.println("Please enter the Fox Death Age in Months");
    }
    public static void displayRabbitDeathAge(){
        System.out.println("Please enter the Rabbit Death Age in Months");
    }

    public static void displayChoicePrompt() {
        System.out.print("Choice: ");
    }

    public static void displayDivider(){
        System.out.println("-------------------------------------------------------------------------------");
    }

}
