package com.ua.sutty.spring.repository;

import com.ua.sutty.spring.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);

    Role findRoleById(Long id);
}
