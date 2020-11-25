package com.sparta.janja;

public class Starter {

    public void start(){
        /**
         * 4 pillars of OOP
         *      1. Abstraction
         *          hiding the unnecessary details
         *          giving a user a layer of abstraction
         *              button in Uber app
         *          showing only the details which are necessary
         *          e.g. Uber, Google Maps, sout(Java handling)
         *          Abstraction can be achieved with either
         *              abstract classes or interfaces
         *
         *      2. Polymorphism
         *          many forms
         *      3. Encapsulation
         *          information hiding (focus on access modifiers)
         *          making your members private
         *          giving each variable just as much access as it needs
         *          giving the outer world just enough information that they need to interact with
         *      4. Inheritance
         *          extends keyword for defining parent and child reationship
         */

        // creating a new instance of an object: resides in heap
        // defualt constructor
        Dog dog = new Dog("Tom", 10, "Dalmatian");
        dog.speak();



    }
}
