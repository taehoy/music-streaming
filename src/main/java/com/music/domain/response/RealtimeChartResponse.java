package com.music.domain.response;

import com.music.domain.Music;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RealtimeChartResponse {
    private Long musicId;
    private String title;
    private String artist;
    private String album;
    private String coverImageUrl;
    private String youtubeUrl;

    public static String extractYoutubeId(String url) {
        if (url == null || !url.contains("/embed/")) return null;
        return url.substring(url.indexOf("/embed/") + "/embed/".length());
    }


}
