package com.music.service;

import com.music.domain.Music;
import com.music.domain.Playlist;
import com.music.domain.dto.MusicDto;
import com.music.domain.response.PlaylistDetailResponse;
import com.music.domain.response.PlaylistResponse;
import com.music.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public void createPlaylist(Long userId, String name) {
        Playlist playlist = Playlist.builder()
                .userId(userId)
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();

        playlistRepository.save(playlist);
    }

    public List<PlaylistResponse> getPlaylistsByUser(Long userId) {
        List<Playlist> playlists = playlistRepository.findByUserId(userId);
        return playlists.stream()
                .map(p -> new PlaylistResponse(p.getId(), p.getName(), 0))
                .collect(Collectors.toList());
    }

    public void addMusic(Long playlistId, Long musicId) {
        playlistRepository.addMusicToPlaylist(playlistId, musicId);
    }

    public PlaylistDetailResponse getPlaylistDetail(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId);
        List<Music> musicList = playlistRepository.findMusicsInPlaylist(playlistId);

        List<MusicDto> musics = musicList.stream()
                .map(m -> new MusicDto(
                        m.getId(),
                        m.getTitle(),
                        m.getArtist(),
                        m.getAlbum(),
                        extractYoutubeId(m.getYoutubeUrl())
                ))
                .collect(Collectors.toList());

        return new PlaylistDetailResponse(playlist.getId(), playlist.getName(), musics);
    }

    private String extractYoutubeId(String url) {
        if (url == null || !url.contains("/embed/")) return null;
        return url.substring(url.indexOf("/embed/") + 7);
    }

}
