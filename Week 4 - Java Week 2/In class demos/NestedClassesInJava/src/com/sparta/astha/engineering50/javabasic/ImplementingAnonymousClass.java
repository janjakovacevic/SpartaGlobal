package com.sparta.astha.engineering50.javabasic;


/*I will never do this just doing for shortcut understanding*/

class Sparta{
    public void aboutMethod(){
        System.out.println("It is a Skills Powerhouse");
    }
}

/*class LondonAcademy extends Sparta{

    @Override
    public void aboutMethod(){
        System.out.println("It is a Skills Powerhouse but situated in London");
    }
}*/

interface Spartan{
    public void graduateStatus();
}

/*class SpartanOnsite implements Spartan{

    @Override
    public void graduateStatus() {
        System.out.println("They have already graduated");
    }
}*/



public class ImplementingAnonymousClass {


      Sparta londonAcademy=new Sparta(){
          @Override
          public void aboutMethod(){
              System.out.println("It is a Skills Powerhouse but situated in London");
          }

      };

      Spartan spartanOnsite=new Spartan(){

          @Override
          public void graduateStatus() {
              System.out.println("They have already graduated");
          }
      };
}


