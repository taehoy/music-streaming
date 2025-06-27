package com.music.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaylistMusic {
    private Long playlistId;
    private Long musicId;
    private int sortOrder;

    public PlaylistMusic(Long playlistId, Long musicId, int sortOrder) {
        this.playlistId = playlistId;
        this.musicId = musicId;
        this.sortOrder = sortOrder;
    }
}
