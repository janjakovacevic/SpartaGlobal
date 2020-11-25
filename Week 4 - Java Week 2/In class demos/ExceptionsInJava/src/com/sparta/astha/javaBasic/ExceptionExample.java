package com.sparta.astha.javaBasic;
//Also called Built-in Exception
public class ExceptionExample {

    public void testExceptions() {//throws ArithmeticException, Exception   {
        int number1 = 10, number2 = 0;
        int myArray[]=new int[10];

        // Attempting to divide by zero
         //  try{
           //Printer.print("MyArray element 11::"+myArray[10]);

           int quotient = number1 / number2;
           throw new ArithmeticException();//throwing a raised exception for a different class to handle
 //        }
//        catch (ArithmeticException e) {
//            e.printStackTrace();
//            Printer.print(e.getMessage());
//        }
//        catch(ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//            Printer.print(e.getMessage());
//        }
//           catch (Exception e) {
//               e.printStackTrace();
//           }

//        finally { //this will run irrespective of whether an exception is being raised or not
//           Printer.print("Finally will always execute!");//closing i/o file streams and closing database connections        }
//
//        }
//
//        /*catch(ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//            Printer.print(e.getMessage());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }*/
//        /*finally{
//            Printer.print("Yayy!! Caught an exception!");
//        }
//*/
        //Printer.print("End of Exception method");
    }
}

