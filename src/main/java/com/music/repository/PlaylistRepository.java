package com.music.repository;

import com.music.domain.Music;
import com.music.domain.Playlist;

import java.util.List;

public interface PlaylistRepository {
    void save(Playlist playlist);
    List<Playlist> findByUserId(Long userId);

    void addMusicToPlaylist(Long playlistId, Long musicId);

    Playlist findById(Long playlistId);
    List<Music> findMusicsInPlaylist(Long playlistId);
    void removeMusicFromPlaylist(Long playlistId, Long musicId);

}
