package com.heartForecast.domain.child.presentation.dto.request;

import com.heartForecast.domain.child.domain.value.Gender;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "아이 생성 요청 DTO")
public record ChildCreateRequest(
    @Schema(description = "아이 이름", example = "홍길동")
    String username,
    @Schema(description = "아이 생일 (YYYY-MM-DD)", example = "2020-03-15")
    LocalDate birthdate,
    @Schema(description = "아이 성별 (예: 남성, 여성, 기타)", example = "남성")
    Gender gender,
    @Schema(description = "아이 건강 정보", example = "알레르기: 땅콩")
    String healthInfo
) {}
