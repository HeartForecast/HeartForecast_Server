package com.heartforecast.domain.child.presentation.dto.response;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.domain.value.Gender;

import java.time.LocalDate;

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
    @Schema(description = "아이 포인트", example = "100")
    Integer point,
    @Schema(description = "아이 고유 초대 코드", example = "ABCD1234")
    String inviteCode
) {
  public static ChildResponse from(Child child) {
    return new ChildResponse(
        child.getId(),
        child.getUsername(),
        child.getBirthdate(),
        child.getGender(),
        child.getHealthInfo(),
        child.getPoint(),
        child.getInviteCode()
    );
  }
}
