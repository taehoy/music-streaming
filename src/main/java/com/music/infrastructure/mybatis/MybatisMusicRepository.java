package com.music.infrastructure.mybatis;

import com.music.domain.Music;
import com.music.infrastructure.mybatis.mapper.MusicMapper;
import com.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisMusicRepository implements MusicRepository {
    private final MusicMapper musicMapper;

    @Override
    public void save(Music music) {
        musicMapper.insert(music);
    }

    @Override
    public Optional<Music> findById(Long id) {
        return Optional.ofNullable(musicMapper.findById(id));
    }

    @Override
    public List<Music> findAll() {
        return musicMapper.findAll();
    }
}
