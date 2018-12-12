package com.ua.sutty.spring.repository;

import com.ua.sutty.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByLogin(String login);

    User findUserByEmail(String email);

    void deleteUserById(Long id);

}
