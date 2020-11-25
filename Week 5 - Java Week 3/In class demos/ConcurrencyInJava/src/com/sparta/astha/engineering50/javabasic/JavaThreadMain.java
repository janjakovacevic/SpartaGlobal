package com.sparta.astha.engineering50.javabasic;

import java.util.concurrent.TimeUnit;

public class JavaThreadMain {

    public static void main(String[] args) {
	// write your code here
        Printer.printMessage("I am inside main");
        Printer.printMessage("1st Approach");
        //Creating a task
        Task task=new Task();
        //Assigning the task to the thread
        Thread thread=new Thread(task);//New State
        //Starting the thread
        thread.setName("Worker");
        thread.start();//Runnable State//Ready State
        Printer.printMessage(Thread.currentThread().getName());
//        Thread thread1=new Thread(new Runnable(){
//
//            @Override
//            public void run() {
//
//            }
//        });
        //thread1.start();
        //thread.start();
        thread.setPriority(Thread.MAX_PRIORITY);
        //time wait state
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //TimeUnit.SECONDS.sleep(1);
            //TimeUnit.NANOSECONDS.sleep(10);

        Printer.printMessage("This is after sleep of main");




        //Printer.printMessage("2nd Approach");
        //AnotherWayToCreateThread anotherWayToCreateThread=new AnotherWayToCreateThread();
        //anotherWayToCreateThread.setName("Worker 2");
        //anotherWayToCreateThread.start();

        //the mo

    }
}
