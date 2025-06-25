package com.music.service;

import com.music.domain.User;
import com.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }
}
