package com.example.security.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @Column(name = "id")
    UUID id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;

    public AppUser() {
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
