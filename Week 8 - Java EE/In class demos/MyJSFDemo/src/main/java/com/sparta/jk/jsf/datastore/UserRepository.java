package com.sparta.jk.jsf.datastore;

import com.sparta.jk.jsf.entities.User;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class UserRepository {

    private HashMap<String, User> validUsers = new HashMap<>();

    {
        validUsers.put("Manish", new User("Manish", "Gadhvi"));
        validUsers.put("Astha", new User("Astha", "Shaw"));
    }

    public HashMap<String, User> getValidUsers() {
        return validUsers;
    }

    // crud - create, read, update, delete
            // assumes usernames are unique



    public User read(String username){
        if(!doesUserExist(username)) {
            throw new NoSuchElementException("no user with that username");
        }
        return getValidUsers().get(username);
    }

    public User updateUsername(String username, String newUsername){
        if(!doesUserExist(username)) {
            throw new NoSuchElementException("no user with that username");
        }
        User user = getValidUsers().get(username);
        user.setUsername(newUsername);
        return user;
    }

    public User updateUser(String username, String newUsername, String newPassword){
        User user = updateUsername(username, newUsername);
        user.setPassword(newPassword);
        return user;
    }

    public User deleteUser(String username){
        if(!doesUserExist(username)) {
            throw new NoSuchElementException("no user with that username");
        }
        return getValidUsers().remove(username);
    }

    public boolean doesUserExist(String username){
        if(getValidUsers().get(username) == null) return false;
        else {
            return true;
        }
    }

}
