package com.graphqlapi.usersubgraph.repositories;

import com.graphqlapi.usersubgraph.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    User saveAndFlush(User user);
}
