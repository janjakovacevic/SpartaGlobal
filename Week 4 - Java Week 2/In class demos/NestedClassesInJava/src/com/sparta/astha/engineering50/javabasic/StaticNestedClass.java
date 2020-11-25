package com.sparta.astha.engineering50.javabasic;


 class StaticNestedClass {
      private static int number=23;
      private static int number2=20;
      private int number5=30;

//      public void test(){
//          System.out.println(InnerStaticClass.number5);
//      }


    static class InnerStaticClass{

        private static int number;

        public  void print(int number){
            Printer.print("I am within inner static Class");
            //System.out.println(StaticNestedClass.this.number);
            Printer.print("number2",number2);
            StaticNestedClass outerClass=new StaticNestedClass();
            System.out.println(outerClass.number);//23
            System.out.println(number);//6//Shadowing effect
            System.out.println(this.number);//0
            Printer.print("number5",outerClass.number5);
        }

    }


}
