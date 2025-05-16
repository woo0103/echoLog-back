package com.deli.echolog.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    // 비밀 키 (실제 서비스에서는 application.yml 등에 분리)
    private final String secretKey = "mySuperSecretKeyThatIsVerySecure12345"; // 최소 256bit
    private final long accessTokenValidity = 1000 * 60 * 60; // 1시간

    private final byte[] secret = secretKey.getBytes();

    // ✅ 토큰 생성
    public String createToken(Long memberId, String role) {
        Claims claims = Jwts.claims();
        claims.put("memberId", memberId);
        claims.put("role", role);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + accessTokenValidity);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(secret), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ 토큰에서 사용자 ID 추출
    public Long getMemberId(String token) {
        return Long.valueOf(parseClaims(token).get("memberId").toString());
    }

    // ✅ 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 내부용 claims 파싱
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
