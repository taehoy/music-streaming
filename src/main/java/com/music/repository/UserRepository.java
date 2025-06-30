package com.music.repository;

import com.music.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByLoginId(@Param("loginId") String loginId);
    User insertUser(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUuid(String uuid);
    int existsByLoginId(String loginId);

}
