package com.ua.sutty.spring.repository;

import com.ua.sutty.spring.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
