package com.sparta.jk.jsf.services;

import com.sparta.jk.jsf.datastore.UserRepository;
import com.sparta.jk.jsf.entities.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class RegistrationService {

    @Inject
    UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // register user - returns the right page based on whether the user is valid or invalid
        // if valid --> string (take to valid page) NOT string (take to error page)

    public String redirectUser(User user){
        if(isValidUser(user)) return "welcome";
        return "error";
    }

    public boolean isValidUser(User user){
        if(!userRepository.doesUserExist(user.getUsername())) return false;
        else {
            String username = userRepository.getValidUsers().get(user.getUsername()).getUsername();
            String password = userRepository.getValidUsers().get(user.getUsername()).getPassword();
            return (username.equals(user.getUsername()) &&
                    password.equals(user.getPassword()));
        }
    }


}
