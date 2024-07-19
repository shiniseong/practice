package org.example.domain.service;


import org.example.domain.entity.User;
import org.example.domain.repository.UserRepository;
import org.example.domain.usecase.UserManagement;

import java.util.List;

public class UserService implements UserManagement {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.delete(email);

    }

    @Override
    public User getUser(String email) {
        User result = userRepository.findByEmail(email);
        if (result == null) {
            throw new IllegalArgumentException("User not found");
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
