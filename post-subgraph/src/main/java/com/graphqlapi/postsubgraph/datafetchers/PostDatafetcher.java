package com.graphqlapi.postsubgraph.datafetchers;

import com.graphqlapi.postsubgraph.entities.Post;
import com.graphqlapi.postsubgraph.services.PostService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
@Slf4j
public class PostDatafetcher {
    @Autowired
    PostService postService;

    @DgsMutation
    Post publishPost(@InputArgument String body) {
        Post postCreated = postService.create(body);
        return postCreated;
    }

    @DgsQuery
    List<Post> postsByUserId() {
        log.info("Executing query postsByUserId");
        return postService.getAll();
    }
}
