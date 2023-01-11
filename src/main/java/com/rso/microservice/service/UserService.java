package com.rso.microservice.service;

import com.rso.microservice.entity.User;
import com.rso.microservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
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

}
