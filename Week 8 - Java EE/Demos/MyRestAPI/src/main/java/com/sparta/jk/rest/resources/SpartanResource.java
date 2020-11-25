package com.sparta.jk.rest.resources;

import com.sparta.jk.rest.entities.Spartan;
import com.sparta.jk.rest.storage.SpartanRepository;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

@Path("spartan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpartanResource {

    @Inject
    private SpartanRepository spartanRepository;

    @GET
    @Path("{id}")
    public Spartan findSpartanByID(@PathParam("id") Integer id){
        return spartanRepository.getSpartan(id);
    }

    @GET
    @Path("/all")
    public HashMap<Integer, Spartan> getAllSpartans(){
        return spartanRepository.getAllSpartans();
    }

    // spartan/find?name=Manish
    @GET
    @Path("/find")
    public ArrayList<Spartan> findSpartan(@QueryParam("name") String name) {
        ArrayList<Spartan> foundSpartans = new ArrayList<>();
        for (Spartan spartan : spartanRepository.getAllSpartans().values()) {
            if (spartan.getFirstName().equals(name)) {
                foundSpartans.add(spartan);
            }
        }

        if(foundSpartans.isEmpty()) throw new WebApplicationException(Response.Status.NOT_FOUND);

        return foundSpartans;
    }

}
