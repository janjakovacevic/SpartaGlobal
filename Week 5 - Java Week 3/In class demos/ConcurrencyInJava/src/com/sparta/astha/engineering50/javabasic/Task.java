package com.sparta.astha.engineering50.javabasic;

class Task implements Runnable{

    @Override
    public void run() {
        Printer.printMessage("I am inside run "+Thread.currentThread().getName());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        go_one();

    }

    private void go_one(){
        Printer.printMessage("I am inside go_one "+Thread.currentThread().getName());
        go_two();
    }

    private void go_two(){

        Printer.printMessage("I am inside go_two "+Thread.currentThread().getName());
    }

}

