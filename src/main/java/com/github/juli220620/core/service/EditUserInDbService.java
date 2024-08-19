package com.github.juli220620.core.service;

import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.model.mapping.UserDataToEntityMapper;
import com.github.juli220620.core.persistence.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditUserInDbService implements EditUserService {

    private final UserDao userDao;
    private final FindUserService findUserService;
    private final UserDataToEntityMapper mapper;

    @Override
    public void editUser(UserData data) {
        var serviceData = findUserService.findById(data.getId()).orElseThrow();
        mapper.userDataToUserData(data, serviceData);
        userDao.persistUser(mapper.userDataToEntity(serviceData));
    }
}
