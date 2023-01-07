package com.graphqlapi.postsubgraph.repositories;

import com.graphqlapi.postsubgraph.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends CrudRepository<Post, UUID> {
    Iterable<Post> findAll();
    Post save(Post post);
}
