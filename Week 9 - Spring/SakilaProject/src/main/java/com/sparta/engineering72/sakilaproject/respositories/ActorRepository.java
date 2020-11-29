package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
    List<Actor> findActorsByFirstNameAndLastName(String firstName, String lastName);
    List<Actor> findActorsByFirstName(String firstName);
    List<Actor> findActorsByLastName(String lastName);
    Actor getActorByActorId(Integer id);
}
