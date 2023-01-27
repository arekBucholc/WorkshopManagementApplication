package com.example.workshopmanagementapp.model.web;

import com.example.workshopmanagementapp.model.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController (UserService userService){
        super();
        this.userService = userService;
    }

    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO){
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }
}
