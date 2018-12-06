package com.ua.sutty.spring.repository;

import com.ua.sutty.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
    User findUserById(Long id);
}
