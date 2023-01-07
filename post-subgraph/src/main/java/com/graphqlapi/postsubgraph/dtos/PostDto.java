package com.graphqlapi.postsubgraph.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    UUID id;

    UserDto author;

    UUID title;

    @NonNull
    String body;
}
