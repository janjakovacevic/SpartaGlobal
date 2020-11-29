package com.sparta.engineering72.log;

import com.sparta.engineering72.simulation.Simulator;
import org.apache.logging.log4j.LogManager;

public class Logger {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Simulator.class);

    public static void logError(Exception e) {
        logger.error(e.getMessage(), e);
    }

    public static void logError(Exception e, String message) {
        logger.error(message, e);
    }
}
