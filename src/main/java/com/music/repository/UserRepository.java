package com.music.repository;

import com.music.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserRepository {
    User findByLoginId(@Param("loginId") String loginId);
    User insertUser(User user);
}
