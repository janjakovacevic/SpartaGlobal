package com.sparta.engineering72;

import com.sparta.engineering72.simulation.Simulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintTests {
    @Test
    public void NumberOfMaleRabbitsPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(6,1);
        String message = "The male population of Rabbits: ";

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }

    @Test
    public void NumberOfFemaleRabbitsPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(6,1);
        String message = "The female population of Rabbits: ";

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }
    @Test
    public void NumberOfMaleFoxesPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(6,1);
        String message = "The male population of Foxes: ";

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }
    @Test
    public void NumberOfFemaleFoxesPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(6,1);
        String message = "The female population of Foxes: ";

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }

    @Test
    public void NumberOfDeadRabbitsPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(61,1);
        String message = "The total number of Rabbits that died: ";//at 61 months at least 2 rabbits must have died

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }
    @Test
    public void DeadRabbits1YearPrintTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Simulator.runSimulation(12,1);
        String message = "The total number of Rabbits that died: 0";//at 59 months no rabbits must have died

        String actualMessage = outContent.toString();
        Assertions.assertTrue(actualMessage.contains(message));

    }

    @Test
    public void BreakDownMonthByMonthTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int numberOfMonths = 1;
        Simulator.runSimulation(numberOfMonths,2);
        String message = "Monthly report";
        String actualMessage = outContent.toString();
        int numberOfMonthlyReports = actualMessage.split(message).length - 1;
        Assertions.assertTrue(actualMessage.contains(message) && numberOfMonthlyReports == numberOfMonths + 1);
    }
}
