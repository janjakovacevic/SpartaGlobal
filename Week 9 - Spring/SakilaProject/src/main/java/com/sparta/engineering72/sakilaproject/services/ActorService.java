package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.respositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors(){
        return (List<Actor>)actorRepository.findAll();
    }

    public Actor getActorByID(int id){
        return actorRepository.getActorByActorId(id);
    }

    public List<Actor> getActorsByFullName(String firstName, String lastName){
        return actorRepository.findActorsByFirstNameAndLastName(firstName, lastName);
    }

    public List<Actor> getActorsByFirstName(String firstName){
        return actorRepository.findActorsByFirstName(firstName);
    }

    public List<Actor> getActorsByLastName(String lastName){
        return actorRepository.findActorsByLastName(lastName);
    }

    public String getActorFullNameFromID(Integer id){
        Actor actor = getActorByID(id);
        return actor.getFirstName() + " " + actor.getLastName();
    }


}
