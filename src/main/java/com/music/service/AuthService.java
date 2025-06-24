package com.music.service;

import com.music.domain.SignUpRequest;
import com.music.domain.User;
import com.music.repository.UserRepository;
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
}
