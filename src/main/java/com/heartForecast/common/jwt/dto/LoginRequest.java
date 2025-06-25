package com.heartForecast.common.jwt.dto;

public record LoginRequest(
        String email,
        String password
) {}
