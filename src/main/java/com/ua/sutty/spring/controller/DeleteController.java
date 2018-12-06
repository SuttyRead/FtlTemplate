package com.ua.sutty.spring.controller;

import com.ua.sutty.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {

    @Autowired
    private UserService userService;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/home?successfullyDeleted";
    }

}
