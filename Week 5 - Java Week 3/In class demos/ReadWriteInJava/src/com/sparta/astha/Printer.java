package com.sparta.astha;

import java.time.DateTimeException;

public class Printer {

    public static void printTime(long totalTime){
        System.out.println("totalTime taken in ms"+totalTime/1000000);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printValue(long data){
        System.out.println(data);
    }
}
