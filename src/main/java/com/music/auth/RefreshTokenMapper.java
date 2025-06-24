package com.music.auth;

import com.music.domain.RefreshToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RefreshTokenMapper {
    void save(RefreshToken token);
    RefreshToken findByLoginId(String loginId);
    void deleteByLoginId(String loginId);
}
