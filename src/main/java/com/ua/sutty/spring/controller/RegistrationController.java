package com.ua.sutty.spring.controller;

import com.ua.sutty.spring.form.UserForm;
import com.ua.sutty.spring.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/registration")
    public String getLoginPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(UserForm userForm){
        signUpService.signUp(userForm);
        return "home";
    }

}
