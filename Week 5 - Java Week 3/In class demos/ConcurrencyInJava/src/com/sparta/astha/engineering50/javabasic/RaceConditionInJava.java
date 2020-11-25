package com.sparta.astha.engineering50.javabasic;

public class RaceConditionInJava {

    public static void main(String[] args) {

        BankAccount task=new BankAccount();
        //task.setBalance(100);

        Thread wife =new Thread(task);
        Thread husband=new Thread(task);
        wife.setName("Wife");
        husband.setName("Husband");
        wife.start();
        husband.start();
    }

}

