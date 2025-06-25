package com.music.service;

import com.music.domain.RefreshToken;
import com.music.domain.SignUpRequest;
import com.music.domain.User;
import com.music.domain.request.LoginRequest;
import com.music.repository.AuthRepository;
import com.music.repository.UserRepository;
import com.music.util.JwtProvider;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public User signUp(SignUpRequest request) {
        if (userRepository.findByLoginId(request.loginId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 유저 ID 입니다.");
        }

        User user = User.builder()
                .loginId(request.loginId())
                .password(passwordEncoder.encode(request.password()))
                .username(request.username())
                .createdAt(LocalDateTime.now())
                .build();
        User saveUser = userRepository.insertUser(user);

        return saveUser;
    }

    public Map<String, String> login(LoginRequest request) {
        Optional<User> user = userRepository.findByLoginId(request.loginId());

        // 비밀번호 유효성 점검
        if(user == null || !passwordEncoder.matches(request.password(), user.get().getPassword())){
            throw new IllegalArgumentException("로그인 ID 또는 비밀번호가 올바르지 않습니다.");
        }

        // 엑세스토큰, 리프레쉬 토큰 발급
        String accessToken = jwtProvider.generateAccessToken(user);
        String refreshToken = jwtProvider.generateRefreshToken(user);

        authRepository.deleteByLoginId(user.get().getLoginId()); // 기존 토큰 제거
        authRepository.save(
                RefreshToken.builder()
                        .loginId(request.loginId())
                        .refreshToken(refreshToken)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );
    }

    public RefreshToken findByLoginId(String loginId) {
        return authRepository.findByLoginId(loginId);
    }
}
