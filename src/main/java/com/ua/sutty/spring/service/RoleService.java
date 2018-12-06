package com.ua.sutty.spring.service;

import com.ua.sutty.spring.domain.Role;
import com.ua.sutty.spring.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final Logger LOGGER = LoggerFactory
            .getLogger(RoleService.class.getName());


    @Autowired
    private RoleRepository roleRepository;

    public void save(Role role) {
        if (role == null) {
            LOGGER.error("Role == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method save");
            roleRepository.save(role);
        } catch (Exception e) {
            LOGGER.error("Error in time save role", e);
            throw e;
        }
    }

    public void delete(Role role) {
        if (role == null) {
            LOGGER.error("Role == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method delete");
            roleRepository.delete(role);
        } catch (Exception e) {
            LOGGER.error("Error in time delete role", e);
            throw e;
        }
    }

    public Role findRoleByName(String name) {
        if (name == null) {
            LOGGER.error("Name == null", new NullPointerException());
            throw new NullPointerException();
        }
        try{
            LOGGER.trace("Call method findRoleByName");
            return roleRepository.findRoleByName(name);
        }catch (Exception e){
            LOGGER.error("Error in time findRoleByName", e);
            throw e;
        }
    }

    public Role findRoleById(Long id) {
        if (id == null) {
            LOGGER.error("Role(id) == null", new NullPointerException());
            throw new NullPointerException();
        }
        try {
            LOGGER.trace("Call method findRoleById");
            return roleRepository.findRoleById(id);
        }catch (Exception e){
            LOGGER.error("Error in time findRoleById", e);
            throw e;
        }
    }

}
