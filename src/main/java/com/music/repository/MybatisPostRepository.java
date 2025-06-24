package com.music.repository;

import com.music.domain.Post;
import com.music.repository.mybatis.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisPostRepository implements PostRepository{

    private final PostMapper postMapper;

    @Override
    public List<Post> findAll() {
        return postMapper.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postMapper.findById(id);
    }

    @Override
    public void insert(Post post) {
        postMapper.insert(post);
    }

    @Override
    public void update(Post post) {
        postMapper.update(post);
    }

    @Override
    public void delete(Long id) {
        postMapper.delete(id);
    }
}
