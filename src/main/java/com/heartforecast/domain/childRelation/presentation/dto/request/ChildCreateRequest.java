package com.heartforecast.domain.childRelation.presentation.dto.request;

import com.heartforecast.domain.child.domain.value.Gender;

import java.time.LocalDate;

public record ChildCreateRequest(
    String username,
    LocalDate birthdate,
    Gender gender,
    String healthInfo
) {}


