package com.heartforecast.common.jwt.dto;

public record LoginRequest(
        String email,
        String password
) {}
