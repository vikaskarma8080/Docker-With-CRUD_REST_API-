package com.job.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.app.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    Optional<Users> findByEmail(String email);
}
