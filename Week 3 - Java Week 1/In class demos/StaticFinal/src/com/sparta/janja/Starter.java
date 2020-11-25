package com.sparta.janja;

public class Starter {

    static{
        System.out.println("Static block 3");
        //prints first as Starter class loads first
    }

    public void start(){
        Spartan spartan1 = new Spartan("Janja", 22, "Female");

        Printer.printSpartanCount(spartan1);

        Spartan spartan2 = new Spartan();
        spartan2.setSpartanName("Shahid");
        spartan2.setAge(21);
        spartan2.setGender("Male");

        Printer.printSpartanCount(spartan2);

        Spartan spartan3 = new Spartan("Chris", 20, "Male");

        Printer.printSpartanCount(spartan3);

        Printer.printTotalSpartanCount();


    }


    static{
        System.out.println("Static block 4");
        //prints second, loads before Spartan class gets loaded
    }

}
