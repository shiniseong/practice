package org.example.windows.dto.response;

import org.example.domain.entity.User;

public record UserResponseDto(
        String name,
        String email
) {
    public static UserResponseDto of(User user) {
        return new UserResponseDto(user.name(), user.email());
    }
}
