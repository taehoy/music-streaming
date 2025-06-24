package com.music.controller;

import com.music.domain.Post;
import com.music.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        log.info("게시글 전체 조회");
        for (Post post : posts) {
            log.info(post.toString());
        }
        return "posts";
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
        return "redirect:/posts";
    }

    @GetMapping("/post/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping("/post/{id}/edit")
    public String edit(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String content) {
        postService.updatePost(id, title, content);
        return "redirect:/post/" + id;
    }

    @PostMapping("/post/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
