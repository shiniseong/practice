package org.example.domain.usecase;

import org.example.domain.entity.User;

import java.util.List;

public interface UserManagement {
    User createUser(User user);

    User updateUser(User user);

    void deleteUser(String email);

    User getUser(String email);

    List<User> getUsers();
}
