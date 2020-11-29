package com.sparta.jk.springbootapp.services;

import com.sparta.jk.springbootapp.entities.Actor;
import com.sparta.jk.springbootapp.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors(){
        return (List<Actor>) actorRepository.findAll();
    }

    public List<Actor> getActorsByFirstName(String firstName) {
        return actorRepository.getActorsByFirstName(firstName);
    }

    public List<Actor> getActorsByLastName(String lastName){
        return actorRepository.getActorsByLastName(lastName);
    }

}
