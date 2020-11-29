package com.sparta.jk.springbootapp.repositories;

import com.sparta.jk.springbootapp.entities.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> getActorsByFirstName(String firstName);
    List<Actor> getActorsByLastName(String lastName);
}
