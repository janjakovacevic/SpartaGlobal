package com.sparta.janja;

public class ThreadCreation implements Runnable{

    public static int id = 0;

    @Override
    public void run() {
        synchronized (this) {
            Printer.printIds(id++);
        }
    }

}

