package com.music.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RefreshToken {
    private Long id;
    private String loginId;
    private String refreshToken;
    private LocalDateTime createdAt;
}
