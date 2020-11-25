package com.sparta.janja;

public class Printer {
    public static void print(Container container){
        System.out.println(container.getContents());
    }

    public static void printDouble(Container container){
        System.out.println(container.getDoubleConstant());
    }

    public static void print(ContainerGenerics containerGenerics){
        System.out.println(containerGenerics.getContents() + " " + containerGenerics.getValues());
    }

}
