package com.music.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Playlist {
    private Long id;
    private Long userId;
    private String name;
    private LocalDateTime createdAt;
}
