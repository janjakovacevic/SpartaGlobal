package com.sparta.jk.resource;

import com.sparta.jk.entity.ActorEntity;
import com.sparta.jk.service.ActorDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("actor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    ActorDAO actorDAO;

    @GET
    @Path("{id}")
    public ActorEntity findActorByID(@PathParam("id") Integer id){
        return actorDAO.findActorByID(id);
    }

    @GET
    @Path("/all")
    public Collection<ActorEntity> getAllActors(){
        return actorDAO.findAllActors();
    }

    @GET
    @Path("/firstName")
    public Collection<ActorEntity> findActorByFirstName(@QueryParam("name") String name){
        return actorDAO.findActorsByFirstName(name);
    }

    @GET
    @Path("/lastName")
    public Collection<ActorEntity> findActorByLastName(@QueryParam("name") String lastName){
        return actorDAO.findActorsByFirstName(lastName);
    }

}
