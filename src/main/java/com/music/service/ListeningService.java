package com.music.service;

import com.music.domain.dto.ListeningLogMessage;
import com.music.infrastructure.kafka.ListeningLogProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ListeningService {
    private final RankingService rankingService;
    private final ListeningLogProducer logProducer;

    public void playMusic(Long userId, Long musicId) {
        // 1. Redis 점수 증가
        rankingService.increasePlayCount(musicId);
        // 2. kafka 메시지 전송
        ListeningLogMessage message = ListeningLogMessage.builder()
                .userId(userId)
                .musicId(musicId)
                .playedAt(LocalDateTime.now())
                .build();

        logProducer.send(message);

    }

}
