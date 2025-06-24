package com.music.config;

import com.music.repository.MybatisPostRepository;
import com.music.repository.PostRepository;
import com.music.repository.mybatis.PostMapper;
import com.music.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final PostMapper postMapper;

    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository() {
        return new MybatisPostRepository(postMapper);
    }
}
