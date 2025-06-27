package com.music.infrastructure.mybatis.mapper;

import com.music.domain.Music;
import com.music.domain.Playlist;
import com.music.domain.PlaylistMusic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaylistMapper {
    void insertPlaylist(@Param("playlist") Playlist playlist);

    List<Playlist> findByUserId(@Param("userId") Long userId);

    void insertPlaylistMusic(@Param("playlistMusic") PlaylistMusic playlistMusic);
    Integer findMaxSortOrder(@Param("playlistId") Long playlistId);

    Playlist findPlaylistById(@Param("playlistId") Long playlistId);

    List<Music> findMusicsByPlaylistId(@Param("playlistId") Long playlistId);
}
