package com.music.repository;

import com.music.domain.ListeningLog;

import java.util.List;

public interface ListeningLogRepository {
    void save(ListeningLog log);
    List<ListeningLog> findByUserId(Long userId);
}
