package com.music.infrastructure.mybatis.mapper;

import com.music.domain.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MusicMapper {
    void insert(Music music);

    Music findById(Long id);

    List<Music> findAll();
    List<Music> findByKeyword(@Param("keyword") String keyword);

}
