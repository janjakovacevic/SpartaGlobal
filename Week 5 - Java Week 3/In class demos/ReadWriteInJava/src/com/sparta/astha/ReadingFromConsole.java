package com.sparta.astha;

import java.util.Scanner;

public class ReadingFromConsole {

    public static void read(){
        Printer.printMessage("Please enter your name::");
        String data;
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextLine();
       Printer.printMessage(data);

        Printer.printMessage("Please enter your age::");
        int value;
        value=scanner.nextInt();
        Printer.printValue(value);


        }
    }

