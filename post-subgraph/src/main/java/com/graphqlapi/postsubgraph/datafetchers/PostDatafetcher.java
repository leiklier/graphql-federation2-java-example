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

    @DgsQuery
    List<PostDto> postsByAuthor(@InputArgument String authorId) {
        log.info("Executing query postsByUserId");
        List<Post> posts =  postService.getByAuthorId(UUID.fromString(authorId));
        return posts.stream().map(PostMapper::convertEntityToDto).toList();
    }

    @DgsMutation
    PostDto publishPost(@InputArgument String authorId, @InputArgument String body) {
        Post postCreated = postService.create(UUID.fromString(authorId), body);
        PostDto postDto =  PostMapper.convertEntityToDto(postCreated);
        log.info(String.format("Created post with id {%s} and authorId {%s}", postDto.getId(), postDto.getAuthor().getId()));
        return postDto;
    }
}
