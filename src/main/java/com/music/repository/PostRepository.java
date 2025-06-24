package com.music.repository;

import com.music.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findById(Long id);
    void insert(Post post);
    void update(Post post);
    void delete(Long id);
}
