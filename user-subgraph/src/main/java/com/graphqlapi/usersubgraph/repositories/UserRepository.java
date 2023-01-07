package com.graphqlapi.usersubgraph.repositories;

import com.graphqlapi.usersubgraph.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findById(UUID userId);
    Iterable<User> findAll();

    User save(User user);
}
