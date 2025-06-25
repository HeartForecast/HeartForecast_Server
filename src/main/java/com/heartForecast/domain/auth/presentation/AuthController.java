package com.heartForecast.domain.auth.presentation;

import com.heartForecast.domain.auth.presentation.dto.request.JoinUserRequest;
import com.heartForecast.domain.auth.service.implementation.ReIssuer;
import com.heartForecast.domain.auth.service.implementation.UserJoiner;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "인증 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserJoiner userJoiner;
    private final ReIssuer reIssuer;

    @Operation(summary = "회원 가입", description = "새로운 회원 정보를 통해 회원 가입을 진행합니다.")
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    public void joinProcess(@RequestBody JoinUserRequest joinUserRequest) {
        userJoiner.joinProcess(joinUserRequest);
    }

    @Operation(summary = "토큰 재발급", description = "리프레시 토큰을 통해 새로운 액세스 토큰과 리프레시 토큰을 재발급받습니다.")
    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.OK)
    public void reissue(HttpServletRequest request, HttpServletResponse response) {
        reIssuer.reissue(request, response);
    }

    @Operation(summary = "인증 상태 체크", description = "현재 요청자가 인증된 상태인지 체크합니다.")
    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public void checkAuthStatus() {
        log.warn("AuthController : /check 성공");
    }
}

