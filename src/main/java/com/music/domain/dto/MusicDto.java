package com.music.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MusicDto {
    private Long musicId;
    private String title;
    private String artist;
    private String album;
    private String youtubeId;

    public MusicDto(Long musicId, String title, String artist, String album, String youtubeId) {
        this.musicId = musicId;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.youtubeId = youtubeId;
    }
}
