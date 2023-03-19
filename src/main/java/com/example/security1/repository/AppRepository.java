package com.example.security1.repository;

import com.example.security1.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppRepository extends JpaRepository<UserApp, Long> {
    UserDetails findByName(String username);
}
