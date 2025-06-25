package com.music.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RedisRankingService implements RankingService{
    private static final String RANKING_KEY = "chart:realtime";
    private final StringRedisTemplate redisTemplate;


    @Override
    public void increasePlayCount(Long musicId) {
        redisTemplate.opsForZSet().incrementScore(RANKING_KEY, String.valueOf(musicId), 1);
    }

    @Override
    public List<Long> getTopMusicIds(int limit) {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Set<String> topIds = zSetOps.reverseRange(RANKING_KEY, 0, limit - 1);
        if(topIds == null) return List.of();

        return topIds.stream().map(Long::valueOf).collect(Collectors.toList());
    }
}
