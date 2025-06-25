package com.music.infrastructure.mybatis.mapper;

import com.music.domain.ListeningLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListeningLogMapper {
    void insert(ListeningLog log);
    List<ListeningLog> findByUserId(Long userId);
}
