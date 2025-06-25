package com.heartforecast.domain.auth.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 가입 요청 DTO")
public record JoinUserRequest(
    @Schema(description = "회원 이메일", example = "user@example.com")
    String email,
    @Schema(description = "회원 이름", example = "홍길동")
    String username,
    @Schema(description = "회원 비밀번호", example = "securePass123")
    String password
) {}
