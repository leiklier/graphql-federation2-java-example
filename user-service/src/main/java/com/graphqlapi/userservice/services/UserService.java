package com.graphqlapi.userservice.services;

import com.graphqlapi.userservice.entities.User;
import com.graphqlapi.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(String firstName, String lastName) {
        User newUser = new User(firstName, lastName);
        User userCreated = userRepository.saveAndFlush(newUser);
        return userCreated;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
