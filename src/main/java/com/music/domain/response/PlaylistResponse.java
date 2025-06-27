package com.music.domain.response;

import lombok.Data;

@Data
public class PlaylistResponse {
    private Long playlistId;
    private String name;
    private int musicCount;

    public PlaylistResponse(Long playlistId, String name, int musicCount) {
        this.playlistId = playlistId;
        this.name = name;
        this.musicCount = musicCount;
    }
}
