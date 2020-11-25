package com.sparta.astha.javaBasic;

public class Starter {

    public static void start() {
        // write your code here
        //runError();

        //try {
        //runExceptions();

//        }
//        catch(Exception e){
//            e.printStackTrace();
//            Printer.print("Caught in Main method");
//        }
        /*catch(ArithmeticException e){
            e.printStackTrace();
            Printer.print("Caught in Main method-Arithmetic Exception");
        }
        Printer.print("Executed an unchecked Exception");*/


        runCheckedExceptions();


        // Printer.print("Executed a Checked Exception");
//       try {
//           runUserDefinedExceptions();
//          Printer.print("Handled User Defined Exception");
//       } catch (MyException myException) {
//            myException.printStackTrace();
//            Printer.print(myException.getMessage());
//        }

        //      runTryWithout();

        //runTryWith();

        //runPerson();
    }



    private static void runPerson() {
        try {
            Person person1 = new Person("Manit", -1);
            //throw new AgeException("Age should be greater than 0");
        } catch (AgeException e) {
            e.printStackTrace();
            //Printer.print(e.getMessage());
        }
    }

    private static void runCheckedExceptions()  {
        CheckedException checkedException=new CheckedException();

        checkedException.runChecked();

    }

    public static void runError(){
        ErrorsExample errorsExample=new ErrorsExample();
        errorsExample.testError(5);
        Printer.print("Done with Error");
    }

    public static void runExceptions() {// throws Exception {

        ExceptionExample exceptionExample=new ExceptionExample();
        try {

            exceptionExample.testExceptions();

            Printer.print("In run Exceptions");
        }catch(ArithmeticException e){
            e.printStackTrace();
            Printer.print("Caught the exception in runExceptions");
        }
        catch(Exception e){
            e.printStackTrace();
            Printer.print("Exception handled");
        }
    }

    public static void runUserDefinedExceptions() throws MyException {


        double balance[] = {20.0, 1200.0, 5000.0};
        for (int i = 0; i < balance.length - 1; i++) {
            if (balance[i] < 100.0) {

                //UserDefinedExceptionsInJava myException = new UserDefinedExceptionsInJava();
                //UserDefinedExceptionsInJava myException = new UserDefinedExceptionsInJava("User Balance is lower than the expected range of 100.0");
                //throw myException;
                //throw new UserDefinedExceptionsInJava("User Balance is lower than the expected range of 100.0");

                //try {
                throw new MyException("User Balance is lower than the expected range of 100.0");
//                    } catch (MyException e) {
//                        e.getMessage();
//                        e.printStackTrace();
//
//                    }
//                     catch(UserDefinedExceptionsInJava e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }

            }



        }

    }
    public static void runTryWithout(){
        TryWithoutClass tryWithoutClass=new TryWithoutClass();
        tryWithoutClass.fileProcessNoBuffer();

    }

    public static void runTryWith(){
        TryWithClass tryWithClass=new TryWithClass();
        tryWithClass.fileProcessNoBufferUsingTryWith();

    }
    }

