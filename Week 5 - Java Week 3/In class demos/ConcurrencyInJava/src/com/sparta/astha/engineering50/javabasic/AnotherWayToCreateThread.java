package com.sparta.astha.engineering50.javabasic;

public class AnotherWayToCreateThread extends Thread {

    public void run(){
        Printer.printMessage("I am inside run of "+Thread.currentThread().getName());
        go_one();
    }

    private void go_one(){
        Printer.printMessage("I am inside go_one " +Thread.currentThread().getName());
        go_two();
    }

    private void go_two(){

        Printer.printMessage("I am inside go_two "+Thread.currentThread().getName());
    }
}
