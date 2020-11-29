package com.sparta.jk.springbootapp.controllers;

import com.sparta.jk.springbootapp.entities.Actor;
import com.sparta.jk.springbootapp.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public String getActors(ModelMap modelMap){
        List<Actor> actors = actorService.getAllActors();
        modelMap.addAttribute("actors", actors);
        return "actors";
    }

    @GetMapping("/actors/all")
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/actors/id")
    public Actor getActorById(@RequestParam(value = "id") Integer id) {
        return actorService.getAllActors().get(id-1);
    }

    @GetMapping("/actors/firstName")
    public List<Actor> getActorsByFirstName(@RequestParam(value = "search") String firstName) {
        return actorService.getActorsByFirstName(firstName);
    }

    @GetMapping("/actors/lastName")
    public List<Actor> getActorsByLastName(@RequestParam(value = "search") String lastName) {
        return actorService.getActorsByLastName(lastName);
    }

}
