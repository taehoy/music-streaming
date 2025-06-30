package com.music.controller;

import com.music.domain.RefreshToken;
import com.music.domain.request.SignUpRequest;
import com.music.domain.User;
import com.music.domain.request.LoginRequest;
import com.music.service.AuthService;
import com.music.service.UserService;
import com.music.util.JwtProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private final JwtProvider jwtProvider;


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest request) {
        try {
            log.info("회원가입 요청 : loginId = {}", request.loginId());
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

    /**
     * 로그인 기능
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        try {
            log.info("로그인 요청: {}", request.loginId());
            Map<String, String> tokens = authService.login(request);
            log.info("로그인 성공: accessToken={}, refreshToken={}", tokens.get("accessToken"), tokens.get("refreshToken"));

            return ResponseEntity.ok(tokens); // ✅ accessToken + refreshToken 모두 응답
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "status", 401,
                            "errorCode", "LOGIN_FAILED",
                            "message", e.getMessage()
                    ));
        }
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");

        if (!jwtProvider.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("RefreshToken이 유효하지 않습니다.");
        }

        String loginId = jwtProvider.getLoginId(refreshToken);
        RefreshToken saved = authService.findByLoginId(loginId);

        if (saved == null || !saved.getRefreshToken().equals(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("RefreshToken이 일치하지 않습니다.");
        }

        Optional<User> user = userService.findByLoginId(loginId);
        String newAccessToken = jwtProvider.generateAccessToken(user);

        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
    }
}
