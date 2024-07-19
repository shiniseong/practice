package org.example.persistence;

import org.example.domain.entity.User;
import org.example.domain.repository.UserRepository;
import org.example.persistence.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, UserEntity> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.of(user);
        userMap.put(user.email(), userEntity);
        return user;
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = UserEntity.of(user);
        userMap.put(user.email(), userEntity);
        return user;
    }

    @Override
    public void delete(String email) {
        userMap.remove(email);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = userMap.get(email);
        if (userEntity == null) {
            return null;
        }
        return userEntity.toDomain();
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().map(UserEntity::toDomain).toList();
    }
}
