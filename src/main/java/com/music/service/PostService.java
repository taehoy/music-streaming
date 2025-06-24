package com.music.service;

import com.music.domain.Post;
import com.music.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id);
    }

    public void createPost(String title, String content, String author) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.insert(post);
    }

    public void updatePost(Long id, String title, String content) {
        Post post = postRepository.findById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            postRepository.update(post);
        }
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }
}
