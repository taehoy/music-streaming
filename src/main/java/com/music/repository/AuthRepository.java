package com.music.repository;

import com.music.domain.RefreshToken;

public interface AuthRepository {
    void save(RefreshToken token);
    RefreshToken findByLoginId(String loginId);
    void deleteByLoginId(String loginId);
}
