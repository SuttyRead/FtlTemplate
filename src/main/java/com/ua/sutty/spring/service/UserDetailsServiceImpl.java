package com.ua.sutty.spring.service;

import com.ua.sutty.spring.repository.UserRepository;
import com.ua.sutty.spring.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(login).
                orElseThrow(IllegalArgumentException::new));
    }

}
