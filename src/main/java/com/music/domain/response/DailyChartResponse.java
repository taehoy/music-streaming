package com.music.domain.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
public class DailyChartResponse {
    private int chartRank;
    private Long musicId;
    private String title;
    private String artist;
    private int playCount;
    private String youtubeUrl;
}
