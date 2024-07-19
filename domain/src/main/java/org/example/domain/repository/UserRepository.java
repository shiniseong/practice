package org.example.domain.repository;

import org.example.domain.entity.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User update(User user);

    void delete(String email);

    User findByEmail(String email);

    List<User> findAll();
}
