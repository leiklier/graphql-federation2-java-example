package com.graphqlapi.postsubgraph.services;

import com.graphqlapi.postsubgraph.entities.Post;
import com.graphqlapi.postsubgraph.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post create(String body) {
        Post newPost = new Post(body);
        Post postCreated = postRepository.saveAndFlush(newPost);
        return postCreated;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
