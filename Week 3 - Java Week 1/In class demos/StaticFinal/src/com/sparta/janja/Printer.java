package com.sparta.janja;

public class Printer {
    public static void printSpartanCount(Spartan spartan){
        System.out.println("Spartan count::" + spartan.getSpartanCount() + " for spartan " + spartan.getSpartanName());
    }
    public static void printTotalSpartanCount(){
        System.out.println("Total number of Spartans both training and onsite is::" + Spartan.totalSpartanCount());
    }
}

