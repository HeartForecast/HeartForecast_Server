package com.heartForecast.common.jwt.util;

import com.heartForecast.common.jwt.exception.ExpiredRefreshTokenException;
import com.heartForecast.common.jwt.exception.ExpiredTokenException;
import com.heartForecast.common.jwt.exception.RefreshTokenNotFoundException;
import com.heartForecast.domain.auth.domain.Refresh;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

import com.heartForecast.domain.auth.domain.repository.RefreshRepository;
import com.heartForecast.domain.user.domain.value.Role;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final RefreshRepository refreshRepository;
    @Value("${spring.jwt.access.expiration}")
    private long accessTokenExpiration;
    @Value("${spring.jwt.refresh.expiration}")
    private long refreshTokenExpiration;

    public JwtUtil(@Value("${spring.jwt.secret}") String secret, RefreshRepository refreshRepository) {
        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        this.refreshRepository = refreshRepository;
    }

    public Long getId(String token) {
        return Long.valueOf(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("sub", String.class));
    }

    public String getCategory(String token) {
        try {
            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("category", String.class);
        } catch (ExpiredJwtException e) {
            return e.getClaims().get("category", String.class);
        }
    }

    public Role getRole(String token) {
        String roleValue = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
        return Role.fromValue(roleValue);
    }

    public String getLoginType(String token) {
        try {
            return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("loginType", String.class);
        } catch (ExpiredJwtException e) {
            return e.getClaims().get("loginType", String.class);
        }
    }

    public void isExpired(String token) {
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        }
    }

    public void deleteAllTokens(HttpServletResponse response, String refreshToken) {
        Boolean isExist = refreshRepository.existsByRefreshToken(refreshToken);
        if (!isExist) {
            throw new RefreshTokenNotFoundException();
        }

        refreshRepository.deleteByRefreshToken(refreshToken);

        String loginType = getLoginType(refreshToken);

        String accessTokenName = "access_" + loginType.toLowerCase();
        String refreshTokenName = "refresh_" + loginType.toLowerCase();

        ResponseCookie invalidAccessCookie = invalidCookie(accessTokenName);
        ResponseCookie invalidRefreshCookie = invalidCookie(refreshTokenName);

        response.addHeader(HttpHeaders.SET_COOKIE, invalidAccessCookie.toString());
        response.addHeader(HttpHeaders.SET_COOKIE, invalidRefreshCookie.toString());
    }

    public void isExpiredRefresh(String token, HttpServletResponse response) {
        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            deleteAllTokens(response, token);
            throw new ExpiredRefreshTokenException();
        }
    }

    public String createAccessToken(Long id, Role role, String loginType) {
        return createJwt("access", id, role, loginType, accessTokenExpiration);
    }

    public String createRefreshToken(Long id, Role role, String loginType) {
        return createJwt("refresh", id, role, loginType, refreshTokenExpiration);
    }

    public ResponseCookie createAccessCookie(String key, String value){
        return createCookie(key, value, (int) accessTokenExpiration);
    }

    public ResponseCookie createRefreshCookie(String key, String value){
        return createCookie(key, value, (int) refreshTokenExpiration);
    }

    public ResponseCookie invalidCookie(String key){
        return createCookie(key, null, 0);
    }

    public void addRefreshToken(Long userId, String refreshToken) {
        Date date = new Date(System.currentTimeMillis() + refreshTokenExpiration);

        Refresh refresh = Refresh.builder()
                .userId(userId)
                .refreshToken(refreshToken)
                .expiration(date.toString())
                .build();

        refreshRepository.save(refresh);
    }

    public String getTokenFromCookies(HttpServletRequest request, String tokenName) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> tokenName.equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public String getTokenFromCookies(HttpServletRequest request, String... tokenNames) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> Arrays.asList(tokenNames).contains(cookie.getName()))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    private String createJwt(String category, Long id, Role role, String loginType, long expiredMs) {
        return Jwts.builder()
                .claim("category", category)
                .claim("sub", String.valueOf(id))
                .claim("role", role.getValue())
                .claim("loginType", loginType)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKey)
                .compact();
    }

    private ResponseCookie createCookie(String key, String value, int maxAge) {
      return ResponseCookie.from(key, value)
                .maxAge(maxAge)
                .path("/")
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .build();
    }
}
