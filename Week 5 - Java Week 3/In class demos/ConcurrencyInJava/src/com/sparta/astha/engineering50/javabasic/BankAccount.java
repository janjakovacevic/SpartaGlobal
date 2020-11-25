package com.sparta.astha.engineering50.javabasic;

class BankAccount implements Runnable{
    private static int balance=100;
    //Object lock=new Object();
    @Override
    public void run() {

        getBalance();
        makeWithdrawal(75);
        if(balance<0){
            Printer.printMessage("Money has been overdrawn and the balance is "+balance);
        }
    }

    public static void setBalance(int balance) {
        BankAccount.balance = balance;
    }

    //private void makeWithdrawal(int amount) {
    private void makeWithdrawal(int amount){
        //No need to put the below line inside synchronized block
        Printer.printMessage("Hey I am in makeWithdrawal "+Thread.currentThread().getName());//non-critical
        //  String s=new String();
        //"this" is used, which is the instance the makeWithdrawal method is called on
        synchronized (this) {
            //synchronized (s) {
            if (balance >= amount) {
                Printer.printMessage(Thread.currentThread().getName() + " is going to withdraw");
                balance = balance - amount;
                Printer.printMessage(Thread.currentThread().getName() + "has withdrawn " + amount);
            } else {
                Printer.printMessage("Sorry not enough balance for" + Thread.currentThread().getName() + " to withdraw");
            }
        }
    }
    /*Two different locks used to guard the same variable*/
    /* */
    public void deposit(int amount){
        //public synchronized void deposit(int amount){
        //String lock=new String();
        synchronized (this) {
        //synchronized(lock){
        balance = balance + amount;
        }
        //}

    }
    public int getBalance() {
        // public int getBalance() {

        Printer.printMessage(Thread.currentThread().getName()+" Checks the balance "+balance);
        return balance;
    }


}

