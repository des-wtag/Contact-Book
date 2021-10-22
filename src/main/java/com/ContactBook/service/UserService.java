package com.ContactBook.service;

import com.ContactBook.dto.UserRegistrationDto;
import com.ContactBook.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
