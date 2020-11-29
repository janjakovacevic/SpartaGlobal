package com.sparta.engineering72.starter;

import com.sparta.engineering72.input.InputCollector;
import com.sparta.engineering72.simulation.Simulator;
import com.sparta.engineering72.SimulatorGUI;
import com.sparta.engineering72.view.Display;

public class Starter {
    public static void start() {
        chooseApplicationStart(InputCollector.getApplicationChoice());
    }

    private static void chooseApplicationStart(int input) {
        Display.displayStartMessage();
        if (input == 1) {
            int constantChoice =  InputCollector.getConstantsChoice();
            if (constantChoice != 1) {
                InputCollector.getConstantsInput();
            }
            Display.displayDivider();
            Simulator.runSimulation(InputCollector.getUserInput(), InputCollector.getReportChoice());
        } else if (input == 2) {
            new SimulatorGUI("Rabbit Simulator");
        }
    }
}
