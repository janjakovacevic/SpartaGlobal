package com.sparta.janja.logger;

import com.sparta.janja.controller.SortManagerController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class LoggerClass {

    private static final Logger logger = LogManager.getLogger(SortManagerController.class);

    public static void logTrace(String message){
            logger.trace(message);
        }
    public static void logError(String message){
            logger.error(message);
        }
}
