package com.example.workshopmanagementapp.model;

import com.example.workshopmanagementapp.model.web.UserRegistrationDTO;

public interface UserService {
    User save(UserRegistrationDTO registrationDTO);
}
