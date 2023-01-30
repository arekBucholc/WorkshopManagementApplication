package com.example.workshopmanagementapp.model;

import com.example.workshopmanagementapp.model.web.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO registrationDTO);
}
