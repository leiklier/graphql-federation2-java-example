package com.graphqlapi.userservice.datafetchers;

import com.graphqlapi.userservice.entities.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;

@DgsComponent
public class AllUsersDatafetcher {
    @DgsQuery
    List<User> allUsers() {
        return List.of(
                new User("1234", "Leik", "Lima-Eriksen")
        );
    }
}
