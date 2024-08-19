package com.github.juli220620.core.persistence;

import com.github.juli220620.core.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void persistUser(UserEntity user);

    List<UserEntity> listAll();

    List<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);

    void removeUser(Long id);
}
