package com.rso.microservice.api.mapper;

import com.rso.microservice.api.dto.UserDetailsDto;
import com.rso.microservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserDetailsDto toModel(User user);

    User toModel(UserDetailsDto userDetails);
}
