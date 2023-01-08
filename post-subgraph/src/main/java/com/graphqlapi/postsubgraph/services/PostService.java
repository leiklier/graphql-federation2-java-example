package com.graphqlapi.postsubgraph.services;

import com.graphqlapi.postsubgraph.entities.Post;
import com.graphqlapi.postsubgraph.repositories.PostRepository;
import graphql.com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post create(UUID authorId, String body) {
        Post newPost = new Post(authorId, body);
        Post postCreated = postRepository.save(newPost);
        return postCreated;
    }

    public List<Post> getByAuthorId(UUID authorId) {
        return postRepository.findByAuthorId(authorId);
    }
}
