package com.ContactBook.controller;

import com.ContactBook.dto.UserDto;
import com.ContactBook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")

public class UserRegisterController {

    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto userRegisterDto) {
        userService.save(userRegisterDto);
        return "redirect:/registration?success";
    }
}