package com.authentication.loginregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.authentication.loginregistration.details.CustomUserDetails;
import com.authentication.loginregistration.entity.User;
import com.authentication.loginregistration.repository.UserRepository;

public class CustomUserDetailsService implements  UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User no found");
        }
        return new CustomUserDetails(user);
    }

}
