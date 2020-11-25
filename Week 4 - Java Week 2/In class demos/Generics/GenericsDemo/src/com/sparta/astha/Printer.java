package com.sparta.astha;

public class Printer {

   public static void print(Container container){
       System.out.println(container.getContents());
   }

    public static void printDouble(Container container){
        System.out.println(container.getDoubleContents());
    }

    public static void print(ContainerGenerics containerGenerics){
        System.out.println("Contents::"+containerGenerics.getContents()+" Values::"+containerGenerics.getValues() );
    }

}
