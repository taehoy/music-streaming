package com.music.infrastructure.kafka;

import com.music.common.KafkaTopic;
import com.music.domain.ListeningLog;
import com.music.domain.dto.ListeningLogMessage;
import com.music.repository.ListeningLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListeningLogConsumer {
    private final ListeningLogRepository listeningLogRepository;

    @KafkaListener(topics = KafkaTopic.LISTENING_LOG, groupId = "music-log-consumer")
    public void consume(ListeningLogMessage message) {
        log.info("✅Consume log = {}", message);

        ListeningLog log = ListeningLog.builder()
                .userId(message.getUserId())
                .musicId(message.getMusicId())
                .playedAt(message.getPlayedAt())
                .createdAt(LocalDateTime.now())
                .build();

        listeningLogRepository.save(log);
    }
}
