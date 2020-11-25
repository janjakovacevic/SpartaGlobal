package com.sparta.janja;

public class Printer {

    public static void printMessage(String message){
        System.out.print(message);
    }

    public static void printIds(int i){
        Printer.printMessage(Thread.currentThread().getName() + i + " " + (i+=1) + " " + (i+=1) + "\n");
    }

    public static void printNHSID(int NHSID){
        System.out.print(" NHSID:: " + NHSID);
    }

    public static void printNIID(int NIID){
        System.out.print(" NIID:: " + NIID);
    }

    public static void printPersonID(int PersonID){
        System.out.println(" PersonID:: " + PersonID);
    }

}
