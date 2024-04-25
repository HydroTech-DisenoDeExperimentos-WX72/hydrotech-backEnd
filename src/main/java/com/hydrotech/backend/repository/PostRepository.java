package com.hydrotech.backend.repository;

import com.hydrotech.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Checks if a post with the specified title already exists.
     *
     * @param title The title of the post.
     * @return True if a post with the specified title exists, false otherwise.
     */
    Boolean existsByTitle(String title);
}
