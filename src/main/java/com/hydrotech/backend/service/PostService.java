package com.hydrotech.backend.service;

import com.hydrotech.backend.model.Post;


public interface PostService {

    /**
     * Creates a new post.
     *
     * @param post The post to be created.
     * @return The created post.
     */
    Post createPost(Post post);
}
