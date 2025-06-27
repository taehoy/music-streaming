package com.music.domain.response;

import com.music.domain.dto.MusicDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlaylistDetailResponse {
    private Long playlistId;
    private String name;
    private List<MusicDto> musics;

    public PlaylistDetailResponse(Long playlistId, String name, List<MusicDto> musics) {
        this.playlistId = playlistId;
        this.name = name;
        this.musics = musics;
    }
}
