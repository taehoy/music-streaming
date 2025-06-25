package com.music.service;

import com.music.domain.ListeningLog;
import com.music.domain.dto.ListeningLogMessage;
import com.music.repository.ListeningLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ListeningService {
    private final RankingService rankingService;
//    private final ListeningLogProducer logProducer;
    private final ListeningLogRepository listeningLogRepository;

    public void playMusic(Long userId, Long musicId) {
        // 1. Redis 점수 증가
        rankingService.increasePlayCount(musicId);

        ListeningLog log = ListeningLog.builder()
                .userId(userId)
                .musicId(musicId)
                .playedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now()).build();


        listeningLogRepository.save(log);

    }

}
