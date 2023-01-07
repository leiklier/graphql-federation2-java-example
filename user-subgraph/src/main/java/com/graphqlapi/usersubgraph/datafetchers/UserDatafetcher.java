package com.graphqlapi.usersubgraph.datafetchers;

import com.graphqlapi.usersubgraph.entities.User;
import com.graphqlapi.usersubgraph.services.UserService;
import com.netflix.graphql.dgs.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@DgsComponent
@Slf4j
public class UserDatafetcher {
    @Autowired
    UserService userService;

    @DgsEntityFetcher(name = "User")
    public User user(Map<String, Object> values) {
        UUID userId = UUID.fromString((String) values.get("id"));
        return userService.getById(userId).get();
    }

    @DgsMutation
    User createUser(@InputArgument String firstName,
                    @InputArgument String lastName) {
        User userCreated = userService.create(firstName, lastName);
        return userCreated;
    }

    @DgsQuery
    List<User> allUsers() {
        log.info("Executing query allUsers");
        return userService.getAll();
    }
}
