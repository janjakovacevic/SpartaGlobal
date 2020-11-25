package com.sparta.jk.service;

import com.sparta.jk.entity.ActorEntity;

import javax.persistence.*;
import java.util.Collection;

public class ActorDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ActorEntity findActorByID(Integer id){
        return entityManager.find(ActorEntity.class, id);
    }

    public Collection<ActorEntity> findAllActors(){
        Query query = entityManager.createNamedQuery("ActorEntity.findAll", ActorEntity.class);
        return (Collection<ActorEntity>) query.getResultList();
    }

    public Collection<ActorEntity> findActorsByFirstName(String firstName){
        Query query = entityManager.createNamedQuery("ActorEntity.findByFirstName", ActorEntity.class);
        return (Collection<ActorEntity>) query.setParameter("firstName", firstName).getResultList();
    }

    public Collection<ActorEntity> findActorsByLastName(String lastName){
        Query query = entityManager.createNamedQuery("ActorEntity.findByLastName", ActorEntity.class);
        return (Collection<ActorEntity>) query.setParameter("lastName", lastName).getResultList();
    }

}
