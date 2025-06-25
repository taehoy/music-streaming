package com.music.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ListeningLog {
    private Long id;
    private Long userId;
    private Long musicId;
    private LocalDateTime playedAt;
    private LocalDateTime createdAt;
}
