package com.sparta.janja;

public class Starter {
    public static void start() {
        MyLocalDAO myLocal = new MyLocalDAO();
//        myLocal.connectToDatabase();
        myLocal.addPersons();
        myLocal.readPersons();
    }
}
