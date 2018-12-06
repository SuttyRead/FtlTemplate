package com.ua.sutty.spring.controller;

import com.ua.sutty.spring.domain.User;
import com.ua.sutty.spring.dto.UserDto;
import com.ua.sutty.spring.repository.UserRepository;
import com.ua.sutty.spring.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String getHomePage(Authentication authentication, Model model) {
        User loggedInUser = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        if (loggedInUser.getRole().getId() == 1) {
            List<UserDto> userDto = userRepository.findAll().stream()
                    .map(User::toUserDto)
                    .collect(Collectors.toList());
            model.addAttribute("users", userDto);
            return "admin";
        } else {
            return "user";
        }
    }

}
