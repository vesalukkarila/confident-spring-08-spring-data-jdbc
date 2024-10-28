package com.vesalukkarila.simple.webapp.springboot.service;

import com.vesalukkarila.simple.webapp.springboot.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {
    //atm faking to always to find a user from database
    public User findById(String id){
        String randomName = UUID.randomUUID().toString();
        return new User(id, randomName);
    }
}
