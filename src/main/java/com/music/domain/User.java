package com.music.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private Long id;
    private String loginId;
    private String password;
    private String username;
    private LocalDateTime createdAt;


}
