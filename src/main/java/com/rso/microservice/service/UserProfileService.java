package com.rso.microservice.service;

import com.rso.microservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserService userService;
    private final JwtService jwtService;

    public UserProfileService(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    public User getUserFromJwt(String jwt) {
        String actualJwt = jwt.split("Bearer ")[1];
        String email = jwtService.parseJwtToken(actualJwt);
        if (email != null) {
            return userService.findByEmail(email);
        }

        return null;
    }

    public User updateUser(String jwt, User user) {
        User userJwt = this.getUserFromJwt(jwt);
        if (userJwt != null) {
            // set this date, so it doesn't delete
            user.setId(userJwt.getId());
            user.setPassword(userJwt.getPassword());
            user.setRole(userJwt.getRole());

            return userService.updateUser(user);
        }

        return null;
    }

    public User updatePassword(String jwt, String newPassword) {
        User userJwt = this.getUserFromJwt(jwt);
        if (userJwt != null) {
            userJwt.setPassword(newPassword);

            return userService.updateUser(userJwt);
        }

        return null;
    }

}
