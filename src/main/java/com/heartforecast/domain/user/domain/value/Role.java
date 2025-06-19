package com.heartforecast.domain.user.domain.value;

import lombok.Getter;

@Getter
public enum Role {
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

  public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(value) || role.getValue().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }
}
