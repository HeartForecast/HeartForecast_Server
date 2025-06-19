package com.heartforecast.domain.oauth.handler;

import com.heartforecast.common.jwt.util.JwtUtil;
import com.heartforecast.domain.oauth.service.dto.CustomOAuth2User;
import com.heartforecast.domain.user.domain.Users;
import com.heartforecast.domain.user.domain.repository.UserRepository;
import com.heartforecast.domain.user.domain.value.Role;
import com.heartforecast.domain.user.exception.UserNotFoundException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Value("${server.url}")
    private String redirectUrl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
      log.warn("오어스 성공 핸들러 authentication : {}", authentication);
        CustomOAuth2User customUserDetails = (CustomOAuth2User) authentication.getPrincipal();
      log.warn("오어스 성공 핸들러 {}", customUserDetails.toString());

        Long id = customUserDetails.getId();

        Role role = customUserDetails.getAuthorities().stream()
            .findFirst()
            .map(a -> Role.fromValue(a.getAuthority()))
            .orElse(Role.GUEST);

        Users user = userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);

        boolean isGuest = user.getRole() == Role.GUEST;

        if (isGuest) {
            role = Role.USER;
            user.updateRole(role);
            userRepository.save(user);
            log.warn("오어스 성공 핸들러: GUEST → USER 업데이트");
        }

        String accessToken = jwtUtil.createAccessToken(id, role, "social");
        String refreshToken = jwtUtil.createRefreshToken(id, role, "social");

        jwtUtil.addRefreshToken(id, refreshToken);
        log.warn("소셜 로그인 필터 동작");

        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createAccessCookie("access_social", accessToken).toString());
        response.addHeader(HttpHeaders.SET_COOKIE, jwtUtil.createRefreshCookie("refresh_social", refreshToken).toString());

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
              log.warn("쿠키 탐색 : {}", cookie.getName());
                if ("JSESSIONID".equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    log.warn("JSESSIONID 제거 완료");
                    break;
                }
            }
        }

        log.warn("오어스 성공 핸들러 최종 리다이렉트");
        response.sendRedirect(redirectUrl);
    }
}
