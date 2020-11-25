package com.sparta.janja;

public class Cat extends Animal{
    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }

    @Override
    public void speak() {
        System.out.println("Cat says: meow!");
    }


}
