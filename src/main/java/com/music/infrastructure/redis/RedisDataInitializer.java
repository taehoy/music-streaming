package com.music.infrastructure.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisDataInitializer implements CommandLineRunner {

    private final RedisTemplate redisTemplate;
    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForZSet().add("chart:realtime", "1", 120.0);
        redisTemplate.opsForZSet().add("chart:realtime", "2", 100.0);
        redisTemplate.opsForZSet().add("chart:realtime", "3", 80.0);
    }
}
