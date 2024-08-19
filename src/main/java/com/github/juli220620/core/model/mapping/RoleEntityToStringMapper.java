package com.github.juli220620.core.model.mapping;

import com.github.juli220620.core.model.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleEntityToStringMapper {

    default String roleEntityToString(RoleEntity roleEntity) {
        return roleEntity.getId();
    }

    default RoleEntity stringToRoleEntity(String role) {
        return new RoleEntity(role);
    }

}
