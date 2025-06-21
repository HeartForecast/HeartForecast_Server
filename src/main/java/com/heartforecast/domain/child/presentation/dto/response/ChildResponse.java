package com.heartforecast.domain.child.presentation.dto.response;

import com.heartforecast.domain.child.domain.Child;
import com.heartforecast.domain.child.domain.value.Gender;

import java.time.LocalDate;

public record ChildResponse(
    Long id,
    String username,
    LocalDate birthdate,
    Gender gender,
    String healthInfo,
    Integer point,
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
