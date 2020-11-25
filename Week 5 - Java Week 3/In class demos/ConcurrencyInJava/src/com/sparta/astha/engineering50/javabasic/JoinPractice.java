package com.sparta.astha.engineering50.javabasic;

public class JoinPractice {

    //Exception thrown here to make the demo clearer
    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(new Joins());
        one.setName("one");

        Thread two = new Thread(new Joins());
        two.setName("two");

        Thread three = new Thread(new Joins());
        three.setName("three");

        one.start();
        one.join();//The main thread is the calling thread and waits for one to finish, not t2 and t3. They are running independently
        two.start();
     two.join();
        three.start();
    }
}
