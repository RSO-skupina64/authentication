package com.rso.microservice.service;

import com.rso.microservice.api.dto.LoginRequestDto;
import com.rso.microservice.api.dto.LoginResponseDto;
import com.rso.microservice.entity.ProductType;
import com.rso.microservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final JwtService jwtService;
    private final UserService userService;

    public AuthenticationService(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public LoginResponseDto login(LoginRequestDto loginRequest) {
        // todo: do login
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setAccessToken(jwtService.createNewJwtToken("aljaz.smaljcelj7@gmail.com"));
        return loginResponseDto;
    }

    public boolean checkRole(String role, String jwt) {
        String actualJwt = jwt.split("Bearer ")[1];
        String email = jwtService.parseJwtToken(actualJwt);
        User u = userService.getUserByEmail(email);
        // todo: check role for user
        return true;
    }

    public User register(User user) {
        return userService.createUser(user);
    }

}
