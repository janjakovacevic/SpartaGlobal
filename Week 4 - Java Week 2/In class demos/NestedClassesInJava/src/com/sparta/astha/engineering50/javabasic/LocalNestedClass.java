package com.sparta.astha.engineering50.javabasic;


public class LocalNestedClass {
    private int number=23;

    public void outerMethod(){
        int number2=6;
        Printer.print("number",number);
           class InnerLocalClass{

               public void innerLocalMethod(){
                   Printer.print("It is within inner Local Class");
                   Printer.print("number",number);
                   Printer.print("number2",number2);

               }


        }

        //outside inner Local Class and in outer method
        InnerLocalClass innerLocalClass=new InnerLocalClass();
        innerLocalClass.innerLocalMethod();

        }


        }

