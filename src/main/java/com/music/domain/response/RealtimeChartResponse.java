package com.music.domain.response;

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
}
