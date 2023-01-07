package com.graphqlapi.postsubgraph.datafetchers;

import com.graphqlapi.postsubgraph.dtos.PostDto;
import com.graphqlapi.postsubgraph.dtos.UserDto;
import com.graphqlapi.postsubgraph.entities.Post;
import com.graphqlapi.postsubgraph.mappers.PostMapper;
import com.graphqlapi.postsubgraph.services.PostService;
import com.netflix.graphql.dgs.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@DgsComponent
@Slf4j
public class PostDatafetcher {
    @Autowired
    PostService postService;

    @Autowired
    PostMapper postMapper;

    @DgsEntityFetcher(name = "User")
    public UserDto user(Map<String, Object> values) {
        return new UserDto((UUID) values.get("id"));
    }

    @DgsMutation
    PostDto publishPost(@InputArgument String authorId, @InputArgument String body) {
        Post postCreated = postService.create(UUID.fromString(authorId), body);
        PostDto postDto =  postMapper.convertEntityToDto(postCreated);
        log.info(String.format("Created post with id {%s} and authorId {%s}", postDto.getId(), postDto.getAuthor().getId()));
        return postDto;
    }

    @DgsQuery
    List<Post> postsByUserId() {
        log.info("Executing query postsByUserId");
        return postService.getAll();
    }
}
