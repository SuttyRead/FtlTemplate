package com.ua.sutty.spring.controller;

import com.ua.sutty.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/edit/{id}")
    public String getAddPage(@PathVariable Long id, Model model) {
        model.addAttribute("userForEdit", userRepository.findUserById(id));
        return "edit";
    }

}
