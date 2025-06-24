package com.music.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
