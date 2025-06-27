package com.music.infrastructure.mybatis;

import com.music.domain.Music;
import com.music.domain.Playlist;
import com.music.domain.PlaylistMusic;
import com.music.infrastructure.mybatis.mapper.PlaylistMapper;
import com.music.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisPlaylistRepository implements PlaylistRepository {
    private final PlaylistMapper playlistMapper;


    @Override
    public void save(Playlist playlist) {
        playlistMapper.insertPlaylist(playlist);
    }

    @Override
    public List<Playlist> findByUserId(Long userId) {
        return playlistMapper.findByUserId(userId);
    }

    @Override
    public void addMusicToPlaylist(Long playlistId, Long musicId) {
        Integer maxOrder = playlistMapper.findMaxSortOrder(playlistId);
        int nextOrder = maxOrder + 1;

        PlaylistMusic playlistMusic = new PlaylistMusic(playlistId, musicId, nextOrder);
        playlistMapper.insertPlaylistMusic(playlistMusic);
    }

    @Override
    public Playlist findById(Long playlistId) {
        return playlistMapper.findPlaylistById(playlistId);
    }

    @Override
    public List<Music> findMusicsInPlaylist(Long playlistId) {
        return playlistMapper.findMusicsByPlaylistId(playlistId);
    }
}
