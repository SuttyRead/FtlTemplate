package com.ua.sutty.spring.controller;

import com.ua.sutty.spring.domain.User;
import com.ua.sutty.spring.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        User user = userDetails.getUser();
        return "home";
    }

}
