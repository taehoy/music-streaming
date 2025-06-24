package com.music.controller;

import com.music.domain.SignUpRequest;
import com.music.domain.response.ErrorResponse;
import com.music.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest request) {
        try {
            authService.signUp(request);
            // 302 리다이렉트 응답
            return ResponseEntity.ok(Map.of("redirectTo", "/login"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", 400,
                    "errorCode", "DUPLICATE_LOGIN_ID",
                    "message", e.getMessage()
            ));
        }
    }
}
