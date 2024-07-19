package org.example.persistence.entity;

import org.example.domain.entity.User;

public record UserEntity(
        String name,
        String email,
        String password
) {
    public User toDomain() {
        return new User(name, email, password);
    }

    public static UserEntity of(User user) {
        return new UserEntity(user.name(), user.email(), user.password());
    }
}
