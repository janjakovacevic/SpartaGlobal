package com.sparta;


public class LoopsInJava {

    public void forLoop(){
        for(int i = 0; i < 5; i++){
            System.out.println("Hello World!");
        }
    }

    public void whileLoop(){
        int i = 5;
        while(i > 0){
            System.out.println(i);
            System.out.println("number--: "+ i--);
            System.out.println("--number: "+ --i);
            i--;
        }
    }

    public void doWhile(){
        int i = 1;
        do{
            System.out.println(i);
        } while(i > 2);
    }

    public void forEach(){
        int[] intArray = {1,2,3,4,5,6,7};
        //default of 0

        for(int i : intArray) {
            System.out.println(i);
            if (i == 1) {
                System.out.println("cont");
                continue;
            } else {
                break;
            }
        }
    }

}
