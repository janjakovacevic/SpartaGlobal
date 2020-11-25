package com.sparta.astha;

public class Starter {

    public static void start(){

        Container container=new Container();
        container.setContents(25);

        Container container1=new Container();
        container.setDoubleContents(23.4);

        Printer.print(container);

        //Generics

//        ContainerGenerics<Integer> containerInteger=new ContainerGenerics();
//        containerInteger.setContents(25);
//
//        ContainerGenerics<String> containerString=new ContainerGenerics();
//        containerString.setContents("Hello");

//        Printer.print(containerInteger);
//        Printer.print(containerString);

        ContainerGenerics<Integer,Double> containerGenerics=new ContainerGenerics(12, 12.5);
        Printer.print(containerGenerics);



    }
}
