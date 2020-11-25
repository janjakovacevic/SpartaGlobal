package com.sparta.astha.engineering50.javabasic;

public class NonStaticNestedClass {
    private int number;
    private int number2;
    private static int number3=10;


    public void runInnerClass(){
        InnerNonStaticClass innerNonStaticClass=new InnerNonStaticClass();
        innerNonStaticClass.nonStaticMethod(6);
        //innerNonStaticClass.getNum();
    }

    class InnerNonStaticClass{
        //try making it private
        private int number=23;


        private int number3=11;
        void nonStaticMethod(int number){
            //access non-static member variables directly
            Printer.print("number2",number2);
            //access static member variables directly
            Printer.print("number3",number3);//11
            Printer.print("NonStaticNestedClass.number3",NonStaticNestedClass.number3);//10
            //Shadowing
            Printer.print("Within  method of inner class number::",number);//50
            Printer.print("access member variable of inner class number::",this.number);//23
            Printer.print("access member variable of outer class number::",NonStaticNestedClass.this.number);//0

        }
    }

}
