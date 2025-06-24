package com.music.repository.mybatis;

import com.music.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findByLoginId(@Param("loginId") String loginId);
    void insertUser(User user);
}
