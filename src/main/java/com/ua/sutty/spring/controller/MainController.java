package com.ua.sutty.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage(ModelMap modelMap, Authentication authentication, HttpSession httpSession){
//        if (authentication == null){
//            return "redirect:/login";
//        }
        return "main";
    }

}
