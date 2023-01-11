package com.rso.microservice.api.mapper;

import com.rso.microservice.api.dto.RegistrationRequestDto;
import com.rso.microservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {

    User toModel(RegistrationRequestDto registrationRequest);
}
