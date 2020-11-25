package com.sparta.janja;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger logger = LogManager.getLogger(Starter.class);
    public void runLogger(){
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        logger.trace("something new");
    }
    public void runExceptions(){
        int numerator = 5;
        int denominator = 0;
        try{
            int quotient = numerator / denominator;
        } catch(ArithmeticException e ){
            Printer.print(e.getMessage());
            logger.error("Divided by zero " + e.getMessage());
        } catch (Exception e){
            Printer.print(e.getMessage());
            logger.error("Handling any additional errors " + e.getMessage());
        }
    }

}
