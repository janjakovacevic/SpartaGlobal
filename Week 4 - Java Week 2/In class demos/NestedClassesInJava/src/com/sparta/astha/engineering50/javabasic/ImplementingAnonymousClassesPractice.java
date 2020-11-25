package com.sparta.astha.engineering50.javabasic;

public class ImplementingAnonymousClassesPractice {

//   SpartaAcademy londonAcademy=new SpartaAcademy(){
//       @Override
//       public void aboutMethod() {
//           System.out.println("This is london Academy");
//       }
//   };

    SpartaAcademy londonAcademy=new SpartaAcademy() {
        @Override
        public void aboutMethod() {
            super.aboutMethod();
        }

        public void test(){
            Printer.print("Test Annonymous");
        }
    };

   

    SpartanInterface spartanConsultants=new SpartanInterface() {
        @Override
        public void getGraduationStatus() {
            System.out.println("These are Spartans onsite");
        }
    };


    /*SpartanInterface spartaconsultants=new SpartanInterface() {
        @Override
        public void getGraduationStatus() {
            System.out.println("They have already graduated");
        }
    };*/

}
