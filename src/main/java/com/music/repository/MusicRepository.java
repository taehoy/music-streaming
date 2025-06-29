package com.music.repository;

import com.music.domain.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface MusicRepository {
    void save(Music music);

    Optional<Music> findById(Long id);

    List<Music> findAll();
    List<Music> findByKeyword(@Param("keyword") String keyword);
}
