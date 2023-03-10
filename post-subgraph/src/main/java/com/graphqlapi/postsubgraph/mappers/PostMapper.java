package com.graphqlapi.postsubgraph.mappers;

import com.graphqlapi.postsubgraph.dtos.PostDto;
import com.graphqlapi.postsubgraph.dtos.UserDto;
import com.graphqlapi.postsubgraph.entities.Post;
import org.modelmapper.ModelMapper;

public class PostMapper {

    public static PostDto convertEntityToDto(Post post) {
        ModelMapper modelMapper = new ModelMapper();
        PostDto postDto = modelMapper.map(post, PostDto.class);
        UserDto authorDto = new UserDto(post.getAuthorId());
        postDto.setAuthor(authorDto);

        return postDto;
    }
}
