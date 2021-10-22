package com.ContactBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {



    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }
}
