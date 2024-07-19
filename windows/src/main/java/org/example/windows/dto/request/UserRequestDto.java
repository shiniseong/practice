package org.example.windows.dto.request;


import org.example.domain.entity.User;

public record UserRequestDto(
        String name,
        String email,
        String password
) {
    public User toDomain() {
        return new User(name, email, password);
    }
}
