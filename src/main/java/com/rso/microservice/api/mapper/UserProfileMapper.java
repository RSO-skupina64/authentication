package com.rso.microservice.api.mapper;

import com.rso.microservice.api.dto.UserDetailsDto;
import com.rso.microservice.api.dto.UserDetailsWithIdDto;
import com.rso.microservice.entity.Product;
import com.rso.microservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserDetailsDto toModelUserDetailsDto(User user);

    User toModel(UserDetailsDto userDetails);

    @Mapping(source = "id", target = "idUser")
    UserDetailsWithIdDto toModelUserDetailsWithIdDto(User user);
}
