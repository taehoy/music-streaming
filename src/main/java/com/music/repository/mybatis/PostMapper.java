package com.music.repository.mybatis;

import com.music.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    Post findById(Long id);
    void insert(Post post);
}
