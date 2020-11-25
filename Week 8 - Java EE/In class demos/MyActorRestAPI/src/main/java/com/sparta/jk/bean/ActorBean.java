package com.sparta.jk.bean;

import com.sparta.jk.entity.ActorEntity;
import com.sparta.jk.resource.ActorResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ActorBean {

    @Inject
    ActorEntity actorEntity;

    @Inject
    ActorResource actorResource;

    public ActorEntity getActorEntity() {
        return actorEntity;
    }

    public void setActorEntity(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
    }

    public ActorResource getActorResource() {
        return actorResource;
    }

    public void setActorResource(ActorResource actorResource) {
        this.actorResource = actorResource;
    }

    public String findActor(){
        actorEntity = actorResource.findActorByID(actorEntity.getActorId());
        return "index";
    }
}
