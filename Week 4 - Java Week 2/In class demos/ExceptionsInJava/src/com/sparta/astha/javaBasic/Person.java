package com.sparta.astha.javaBasic;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws AgeException {
        if(age<0){
            throw new AgeException("Please enter an age > 0");
        }
        else {
            this.name = name;
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
