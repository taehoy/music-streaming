package com.music.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ListeningLogMessage {
    private Long userId;
    private Long musicId;
    private LocalDateTime playedAt;
}
