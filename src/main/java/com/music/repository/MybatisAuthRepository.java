package com.music.repository;

import com.music.auth.RefreshTokenMapper;
import com.music.domain.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisAuthRepository implements AuthRepository{

    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public void save(RefreshToken token) {
        refreshTokenMapper.save(token);
    }

    @Override
    public RefreshToken findByLoginId(String loginId) {
        return refreshTokenMapper.findByLoginId(loginId);
    }

    @Override
    public void deleteByLoginId(String loginId) {
        refreshTokenMapper.deleteByLoginId(loginId);
    }
}
