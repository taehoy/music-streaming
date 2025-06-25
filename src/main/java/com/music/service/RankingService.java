package com.music.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RankingService {
    void increasePlayCount(Long musicId);

    List<Long> getTopMusicIds(int limit); // 상위 n개 조회
}
