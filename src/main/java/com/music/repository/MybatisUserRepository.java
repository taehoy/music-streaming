package com.music.repository;

import com.music.domain.User;
import com.music.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository{

    private final UserMapper userMapper;
    @Override
    public User findByLoginId(String loginId) {
        return userMapper.findByLoginId(loginId);
    }

    @Override
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }
}
