package com.example.workshopmanagementapp.model;

import com.example.workshopmanagementapp.model.web.UserRegistrationDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getEmial(),
                registrationDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
