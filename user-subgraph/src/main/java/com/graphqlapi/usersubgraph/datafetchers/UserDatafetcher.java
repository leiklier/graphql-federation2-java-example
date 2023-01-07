package com.graphqlapi.usersubgraph.datafetchers;

import com.graphqlapi.usersubgraph.entities.User;
import com.graphqlapi.usersubgraph.repositories.UserRepository;
import com.graphqlapi.usersubgraph.services.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
@Slf4j
public class UserDatafetcher {
    @Autowired
    UserService userService;

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
