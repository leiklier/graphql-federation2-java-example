package com.graphqlapi.postsubgraph.repositories;

import com.graphqlapi.postsubgraph.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findAll();
    Post saveAndFlush(Post post);
}
