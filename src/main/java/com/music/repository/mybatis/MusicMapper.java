package com.music.repository.mybatis;

import com.music.domain.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
    void insert(Music music);
    Music findById(Long id);
    List<Music> findAll();
}
