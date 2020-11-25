package com.sparta.janja;

public class Dog extends Animal{

    // default modifier: accessible in the package

    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override // method overriding: same method, different implementation
    // type of polymorphism
    // providing a specialized implementation and overriding
    // whatever that method has in the base class
    public void speak() {
        System.out.println("Dog says: woof!");
    }


}
