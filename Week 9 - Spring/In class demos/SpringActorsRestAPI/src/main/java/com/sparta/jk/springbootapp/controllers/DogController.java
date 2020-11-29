package com.sparta.jk.springbootapp.controllers;

import com.sparta.jk.springbootapp.entities.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog("Scooby Doo", "Great Dane");
        Dog dog1 = new Dog("Friday", "Terrier");
        dogs.add(dog);
        dogs.add(dog1);
        return dogs;
    }
}
