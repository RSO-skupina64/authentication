package com.rso.microservice.service;

import com.rso.microservice.api.dto.LoginRequestDto;
import com.rso.microservice.api.dto.LoginResponseDto;
import com.rso.microservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final JwtService jwtService;
    private final UserService userService;

    public AuthenticationService(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public LoginResponseDto login(LoginRequestDto loginRequest) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        User user = userService.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            loginResponseDto.setAccessToken(jwtService.createNewJwtToken(user.getEmail()));
        }

        return loginResponseDto;
    }

    public boolean checkRole(String role, String jwt) {
        String actualJwt = jwt.split("Bearer ")[1];
        String email = jwtService.parseJwtToken(actualJwt);
        User user = userService.findByEmail(email);
        if (user.getRole() != null) {
            return user.getRole().getName().equals(role);
        }

        return false;
    }

    public User register(User user) {
        return userService.createUser(user);
    }

}
