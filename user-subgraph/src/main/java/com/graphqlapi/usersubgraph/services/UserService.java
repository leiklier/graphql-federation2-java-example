package com.graphqlapi.usersubgraph.services;

import com.graphqlapi.usersubgraph.entities.User;
import com.graphqlapi.usersubgraph.repositories.UserRepository;
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
