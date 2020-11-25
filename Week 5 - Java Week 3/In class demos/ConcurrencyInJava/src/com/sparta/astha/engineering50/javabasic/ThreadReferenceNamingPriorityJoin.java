package com.sparta.astha.engineering50.javabasic;

import org.w3c.dom.ls.LSOutput;

public class ThreadReferenceNamingPriorityJoin {

    public static void main(String[] args) {
        //It will give reference to the main thread
        Printer.printMessage(Thread.currentThread().getName());
        Thread t2= new Thread(new MyTask());
        //Thread t1 = new Thread(new MyThreadOne());
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0;i<=10;i++){

                    if(i==5){
                        //Hint to the scheduler that thread
                        //is willing to yield its current use of CPU
                        Thread.currentThread().yield();
                    }
                    Printer.printMessage(Thread.currentThread().getName());
                }
            }
        });


        //setting names
        t1.setName("MyThreadOne");
        t2.setName("MyThreadTwo");

        //setting priority(no real guarantee all depends on scheduler)
        //t1.setPriority(9);
        //t1.setPriority(Thread.MAX_PRIORITY);
        //t2.setPriority(Thread.MIN_PRIORITY);


        t1.start();
        t2.start();

        //join
         //Main thread is suspended until t2 dies

            //t2.join(1);
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//

        Printer.printMessage("I am inside main");


    }
}

   /* class MyThreadOne implements Runnable{

        @Override
        public void run() {

            for (int i=0;i<=10;i++){

                if(i==5){
                    //Hint to the scheduler that thread
                    //is willing to yield its current use of CPU
                    Thread.currentThread().yield();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }*/

    class MyTask implements Runnable{

        @Override
        public void run() {
            for(int i=1; i<=5;i++){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

