package com.music.infrastructure.mybatis;

import com.music.domain.ListeningLog;
import com.music.infrastructure.mybatis.mapper.ListeningLogMapper;
import com.music.repository.ListeningLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisListeningLogRepository implements ListeningLogRepository {

    private final ListeningLogMapper listeningLogMapper;

    @Override
    public void save(ListeningLog log) {
        listeningLogMapper.insert(log);
    }

    @Override
    public List<ListeningLog> findByUserId(Long userId) {
        return listeningLogMapper.findByUserId(userId);
    }
}
