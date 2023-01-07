package com.graphqlapi.usersubgraph.services;

import com.graphqlapi.usersubgraph.entities.User;
import com.graphqlapi.usersubgraph.repositories.UserRepository;
import graphql.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User create(String firstName, String lastName) {
        User newUser = new User(firstName, lastName);
        User userCreated = userRepository.save(newUser);
        return userCreated;
    }

    public Optional<User> getById(UUID userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }
}
