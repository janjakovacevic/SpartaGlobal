package com.sparta.astha.engineering50.javabasic;

class Joins implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            Printer.printMessage(Thread.currentThread().getName() + " " + i);
        }
    }
}