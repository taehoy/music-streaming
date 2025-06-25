package com.music.service;

import org.springframework.stereotype.Component;

@Component
public interface RankingService {
    void increasePlayCount(Long musicId);
}
