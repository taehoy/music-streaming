package com.music.util;

import com.music.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    //todo : secretKey 보안 향상 : 실제 서비스에서는 .env, application.yml, AWS Secret Manager 같은 데서 가져옴
    private final String secretKey = "this-is-a-very-very-long-and-secure-key-1234567890!!!";
    private final long accessTokenExpiration = 1000 * 60 * 60; // 1시간

    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    public String generateAccessToken(User user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + accessTokenExpiration);

        return Jwts.builder()
                .setSubject(user.getLoginId())
                .claim("username", user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
