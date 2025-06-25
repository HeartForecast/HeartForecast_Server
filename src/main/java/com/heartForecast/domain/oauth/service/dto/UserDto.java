package com.heartForecast.domain.oauth.service.dto;

import com.heartForecast.domain.user.domain.value.Role;
import lombok.Builder;

public record UserDto(
        Role role,
        Long id,
        String username
) {

    @Builder
    public UserDto(Role role, Long id, String username) {
        this.role = role;
        this.id = id;
        this.username = username;
    }
}
