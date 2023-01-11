package com.rso.microservice.service;

import com.rso.microservice.api.dto.LoginRequestDto;
import com.rso.microservice.api.dto.LoginResponseDto;
import com.rso.microservice.entity.User;
import com.rso.microservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        User userEmail = userRepository.findByEmail(user.getEmail());
        if (userEmail != null) {
            return null;
        }
        User userUsername = userRepository.findByUsername(user.getUsername());
        if (userUsername != null) {
            return null;
        }

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            return userRepository.save(user);
        }

        return null;
    }

}
