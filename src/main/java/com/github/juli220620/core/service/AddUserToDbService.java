package com.github.juli220620.core.service;

import com.github.juli220620.core.exception.ValidationException;
import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.model.UserEntity;
import com.github.juli220620.core.model.mapping.UserDataToEntityMapper;
import com.github.juli220620.core.persistence.UserDao;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddUserToDbService implements AddUserService {

    private final UserDao userDao;
    private final Validator validator;
    private final UserDataToEntityMapper mapper;

    @Override
    public void addUser(UserData data) {
        var entity = mapper.userDataToEntity(data);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(entity);

        if (violations.isEmpty()) {
            userDao.persistUser(entity);
        } else {
            throw new ValidationException(new ArrayList<>(violations));
        }
    }
}
