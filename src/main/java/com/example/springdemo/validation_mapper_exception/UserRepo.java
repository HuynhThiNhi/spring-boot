package com.example.springdemo.validation_mapper_exception;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
