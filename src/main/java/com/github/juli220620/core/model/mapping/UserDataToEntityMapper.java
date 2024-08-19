package com.github.juli220620.core.model.mapping;

import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.model.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {RoleEntityToStringMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserDataToEntityMapper {

    @Mapping(target = "phoneNumbers", source = "phones")
    UserEntity userDataToEntity(UserData data);

    @InheritInverseConfiguration
    UserData userEntityToData(UserEntity entity);

    void userDataToUserData(UserData source, @MappingTarget UserData target);
}
