package com.music.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MusicSearchResponse {
    private Long musicId;
    private String title;
    private String artist;
    private String album;
    private String coverImageUrl;
    private String youtubeUrl;

    public MusicSearchResponse(Long musicId, String title, String artist, String album, String coverImageUrl, String youtubeUrl) {
        this.musicId = musicId;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.coverImageUrl = coverImageUrl;
        this.youtubeUrl = youtubeUrl;
    }
}
