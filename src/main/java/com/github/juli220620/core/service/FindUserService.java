package com.github.juli220620.core.service;

import com.github.juli220620.core.model.UserData;

import java.util.List;
import java.util.Optional;

public interface FindUserService {

    List<UserData> all();

    Optional<UserData> findById(Long id);

    List<UserData> findAllByEmail(String email);
}
