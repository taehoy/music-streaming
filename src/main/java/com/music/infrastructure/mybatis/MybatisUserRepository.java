package com.music.infrastructure.mybatis;

import com.music.domain.User;
import com.music.infrastructure.mybatis.mapper.UserMapper;
import com.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {

    private final UserMapper userMapper;
    @Override
    public Optional<User> findByLoginId(String loginId) {
        return Optional.ofNullable(userMapper.findByLoginId(loginId));
    }

    @Override
    public User insertUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMapper.findById(id));
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
        return Optional.ofNullable(userMapper.findByUuid(uuid));
    }
}
