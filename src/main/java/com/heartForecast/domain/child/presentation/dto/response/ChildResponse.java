package com.heartForecast.domain.child.presentation.dto.response;

import com.heartForecast.domain.child.domain.Child;
import com.heartForecast.domain.child.domain.value.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.heartForecast.domain.childRelation.domain.ChildRelation;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "아이 정보 반환 DTO")
public record ChildResponse(
    @Schema(description = "아이 ID", example = "1")
    Long id,
    @Schema(description = "아이 이름", example = "홍길동")
    String username,
    @Schema(description = "아이 생일 (YYYY-MM-DD)", example = "2020-03-15")
    LocalDate birthdate,
    @Schema(description = "아이 성별 (예: 남성, 여성, 기타)", example = "여성")
    Gender gender,
    @Schema(description = "아이 건강 정보", example = "알레르기: 땅콩")
    String healthInfo,
    @Schema(description = "등록일", example = "2021-11-08T11:44:30.327959")
    LocalDateTime createdAt,
    @Schema(description = "아이 포인트", example = "100")
    Integer point,
    @Schema(description = "아이 고유 초대 코드", example = "ABCD1234")
    String inviteCode
) {
  public static ChildResponse from(ChildRelation childRelation) {
    return new ChildResponse(
        childRelation.getChild().getId(),
        childRelation.getChild().getUsername(),
        childRelation.getChild().getBirthdate(),
        childRelation.getChild().getGender(),
        childRelation.getChild().getHealthInfo(),
        childRelation.getCreatedAt(),
        childRelation.getChild().getPoint(),
        childRelation.getChild().getInviteCode()
    );
  }
}
