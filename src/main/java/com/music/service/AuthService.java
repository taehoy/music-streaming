package com.music.service;

import com.music.domain.SignUpRequest;
import com.music.domain.User;
import com.music.domain.request.LoginRequest;
import com.music.repository.UserRepository;
import com.music.util.JwtProvider;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
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

    public String login(LoginRequest request) {
        User user = userRepository.findByLoginId(request.loginId());

        // 비밀번호 유효성 점검
        if(user == null || !passwordEncoder.matches(request.password(), user.getPassword())){
            throw new IllegalArgumentException("로그인 ID 또는 비밀번호가 올바르지 않습니다.");
        }

        return jwtProvider.generateAccessToken(user);
    }
}
