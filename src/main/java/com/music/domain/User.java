package com.music.domain;

import com.music.domain.user.UserType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private Long id;
    private String uuid; // 비회원도 가짐.
    private String loginId;     // 비회원은 null
    private String password;    // 비회원은 null
    private String username;    // 비회원은 null
    private UserType type;
    private LocalDateTime createdAt;

}
