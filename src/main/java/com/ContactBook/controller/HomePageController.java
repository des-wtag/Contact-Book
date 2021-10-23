package com.ContactBook.controller;

import com.ContactBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@Configurable
public class HomePageController {



    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(value = "/allContacts")
    public String showAllContact(HttpServletRequest request){
        request.setAttribute("contacts", contactRepository.findAll());
        return "contact_index";
    }
}
