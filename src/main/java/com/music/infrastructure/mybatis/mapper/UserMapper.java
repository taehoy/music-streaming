package com.music.infrastructure.mybatis.mapper;

import com.music.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void insert(User user);
    User findById(Long id);
    User findByUuid(String uuid);
    User findByLoginId(String loginId);
    int existsByLoginId(String loginId);

}
