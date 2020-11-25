package com.sparta.janja.model;

import com.sparta.janja.view.DataMigrationMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author janjakovacevic
 * @project DataMigrationProject
 */

public class LoggerClass {

    private static final Logger logger = LogManager.getLogger(DataMigrationMain.class);

    public static void logTrace(String message){
        logger.trace(message);
    }
    public static void logError(String message){
        logger.error(message);
    }
}
