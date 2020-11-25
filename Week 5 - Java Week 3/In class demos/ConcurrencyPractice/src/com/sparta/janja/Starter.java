package com.sparta.janja;

public class Starter {

    public static void start(){

        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new ThreadCreation());
            thread.setName("Person " + i + ": ");
            thread.start();
        }

    }

}
