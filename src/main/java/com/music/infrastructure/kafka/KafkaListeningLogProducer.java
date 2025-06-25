package com.music.infrastructure.kafka;

import com.music.common.KafkaTopic;
import com.music.domain.dto.ListeningLogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaListeningLogProducer implements ListeningLogProducer{

    private final KafkaTemplate<String, ListeningLogMessage> kafkaTemplate;
    @Override
    public void send(ListeningLogMessage message) {
        kafkaTemplate.send(KafkaTopic.LISTENING_LOG, message);
    }
}
