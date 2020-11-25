package com.sparta.janja;

public class Starter {
    public static void start(){
        Container container = new Container();
        container.setContents(25);
        Printer.print(container);

        container.setDoubleConstant(13.2);
        Printer.printDouble(container);


        // Generics

//        ContainerGenerics<Integer> containerInteger = new ContainerGenerics<>();
//        containerInteger.setContents(25);
//
//        ContainerGenerics<String> containerString = new ContainerGenerics<>();
//        containerString.setContents("Hello");
//
//        Printer.print(containerInteger);
//        Printer.print(containerString);

        ContainerGenerics<Integer, Double> containerGenerics = new ContainerGenerics<>(13, 13.1);
        Printer.print(containerGenerics);
    }
}
