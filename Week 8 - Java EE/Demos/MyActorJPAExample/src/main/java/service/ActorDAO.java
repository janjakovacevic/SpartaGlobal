package service;

import entities.ActorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ActorDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ActorEntity findActorByID(int id){
        return entityManager.find(ActorEntity.class, id);
    }
}
