package com.ua.sutty.spring.form;

import com.ua.sutty.spring.domain.Role;
import com.ua.sutty.spring.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthday;

    public User toUser(){
        String hashPassword = passwordEncoder.encode(password);
        Role role = new Role(2L, "USER");
        return User.builder()
                .login(login)
                .password(hashPassword)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .birthday(birthday)
                .role(role)
                .build();
    }

}
