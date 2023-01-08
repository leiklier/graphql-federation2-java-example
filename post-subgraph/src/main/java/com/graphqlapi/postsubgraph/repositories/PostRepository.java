package com.graphqlapi.postsubgraph.repositories;

import com.graphqlapi.postsubgraph.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAll();
    List<Post> findByAuthorId(UUID authorId);
    Post save(Post post);
}
