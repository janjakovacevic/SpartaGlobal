package com.sparta.astha.javaBasic;

public class ErrorsExample {

    public void testError(int number) {
        // No correct as base condition leads to
        // non-stop recursion.
        if (number == 8)
            return;
        else {
            number++;
            Printer.print("Test");
            testError(number);

        }
    }
}
