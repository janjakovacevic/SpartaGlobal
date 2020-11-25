package bean;

import entities.ActorEntity;
import service.ActorDAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ActorEntityBean {

    @Inject
    ActorEntity actorEntity;

    @Inject
    ActorDAO actorDAO;

    public ActorEntity getActorEntity() {
        return actorEntity;
    }

    public void setActorEntity(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
    }

    public String findActorByID(){
        actorEntity = actorDAO.findActorByID(actorEntity.getActorId());
        if(actorEntity != null) return "actor";
        return "error";
    }

}
