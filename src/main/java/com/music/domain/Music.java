package com.music.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Music {
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int duration; // 초 단위
    private String coverImageUrl;
    private LocalDateTime createdAt;

}
