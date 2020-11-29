package com.sparta.jk.springboot.loginapp.repositories;

import com.sparta.jk.springboot.loginapp.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
}
