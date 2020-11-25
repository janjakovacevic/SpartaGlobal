package com.sparta.jk.jsf.beans;

import com.sparta.jk.jsf.datastore.UserRepository;
import com.sparta.jk.jsf.entities.User;
import com.sparta.jk.jsf.services.RegistrationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named // can also name it
@RequestScoped // lives for the duration of the request
public class UserBean {

    @Inject
    User user;

    @Inject
    RegistrationService registrationService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String addUser(){
        if(registrationService.isValidUser(user)) return "welcome";
//        if(user.getPassword().equals("Gadhvi")) return "welcome";
        return "error";
    }
}
