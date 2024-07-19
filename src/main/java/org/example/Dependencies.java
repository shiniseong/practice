package org.example;

import org.example.domain.repository.UserRepository;
import org.example.domain.service.UserService;
import org.example.domain.usecase.UserManagement;
import org.example.persistence.InMemoryUserRepository;
import org.example.windows.controller.UserController;

public class Dependencies {
    private static final UserRepository userRepository = new InMemoryUserRepository();
    private static final UserManagement userManagement = new UserService(userRepository);
    public static final UserController userController = new UserController(userManagement);
}
