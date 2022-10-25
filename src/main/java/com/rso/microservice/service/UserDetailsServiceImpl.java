package com.rso.microservice.service;

import com.rso.microservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
public class UserDetailsServiceImpl {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        return UserDetailsImpl.build(user);
//    }
}
