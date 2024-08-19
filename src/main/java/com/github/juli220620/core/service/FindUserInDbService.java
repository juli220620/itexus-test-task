package com.github.juli220620.core.service;

import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.model.mapping.UserDataToEntityMapper;
import com.github.juli220620.core.persistence.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindUserInDbService implements FindUserService {

    private final UserDao userDao;
    private final UserDataToEntityMapper mapper;

    @Override
    public List<UserData> all() {
        return userDao.listAll().stream()
                .map(mapper::userEntityToData)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserData> findById(Long id) {
        return userDao.findById(id).map(mapper::userEntityToData);
    }

    @Override
    public List<UserData> findAllByEmail(String email) {
        return userDao.findByEmail(email).stream()
                .map(mapper::userEntityToData)
                .collect(Collectors.toList());
    }
}
