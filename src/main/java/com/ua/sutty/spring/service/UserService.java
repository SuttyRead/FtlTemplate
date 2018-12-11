package com.ua.sutty.spring.service;

import com.ua.sutty.spring.domain.User;
import com.ua.sutty.spring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final Logger LOGGER = LoggerFactory
            .getLogger(UserService.class.getName());


    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        if (user == null) {
            LOGGER.error("User == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method save");
            userRepository.save(user);
        } catch (Exception e) {
            LOGGER.error("Error in time save user", e);
            throw e;
        }
    }

    public void delete(User user) {
        if (user == null) {
            LOGGER.error("Role == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method delete");
            userRepository.delete(user);
        } catch (Exception e) {
            LOGGER.error("Error in time delete user", e);
            throw e;
        }
    }

    public List<User> findAll() {
        try {
            LOGGER.trace("Call method findAll");
            return userRepository.findAll();
        }catch (Exception e){
            LOGGER.error("Error in time findAll", e);
            throw e;
        }
    }

    public Optional<User> findOneByLogin(String login) {
        if (login == null) {
            LOGGER.error("login == null", new NullPointerException());
            throw new NullPointerException();
        }
        try{
            LOGGER.trace("Call method findOneByLogin");
            return userRepository.findOneByLogin(login);
        }catch (Exception e){
            LOGGER.error("Error in time findOneByLogin", e);
            throw e;
        }
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            LOGGER.error("Email == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method findUserByEmail");
            return userRepository.findUserByEmail(email);
        }catch (Exception e){
            LOGGER.error("Error in time findUserByEmail", e);
            throw e;
        }
    }

    public User findUserByLogin(String login) {
        if (login == null) {
            LOGGER.error("Email == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method findUserByLogin");
            return userRepository.findUserByLogin(login);
        }catch (Exception e){
            LOGGER.error("Error in time findUserByLogin", e);
            throw e;
        }
    }

    public User findUserById(Long id) {
        if (id == null) {
            LOGGER.error("User(id) == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method findUserById");
            return userRepository.findUserById(id);
        }catch (Exception e){
            LOGGER.error("Error in time findUserById", e);
            throw e;
        }
    }

    public void deleteUserById(Long id) {
        if (id == null) {
            LOGGER.error("User(id) == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method deleteUserById");
            userRepository.deleteUserById(id);
        }catch (Exception e){
            LOGGER.error("Error in time deleteUserById", e);
            throw e;
        }
    }

}
