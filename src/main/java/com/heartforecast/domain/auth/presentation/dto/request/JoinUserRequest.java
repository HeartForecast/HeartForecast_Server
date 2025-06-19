package com.heartforecast.domain.auth.presentation.dto.request;

public record JoinUserRequest(
    String email,
    String username,
    String password
) {}
