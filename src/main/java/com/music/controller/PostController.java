package com.music.controller;

import com.music.domain.Post;
import com.music.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "viewPost";
    }

    @GetMapping("/post/new")
    public String createForm() {
        return "savePost";
    }


    @PostMapping("/post")
    public String create(@RequestParam String title,
                         @RequestParam String content,
                         @RequestParam String author) {
        postService.createPost(title, content, author);
        return "redirect:/";
    }
}
