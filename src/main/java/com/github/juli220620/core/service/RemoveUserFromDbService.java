package com.github.juli220620.core.service;

import com.github.juli220620.core.persistence.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveUserFromDbService implements RemoveUserService {

    private final UserDao userDao;

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }
}
