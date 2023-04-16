package com.example.security.entity;

import jakarta.persistence.*;

import java.util.Set;
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

    @ManyToMany
    @JoinTable(
            name = "app_user_app_role",
            joinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "app_role_id", referencedColumnName = "id")
    )
    private Set<AppRole> roles;

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

    public Set<AppRole> getRoles() {
        return roles;
    }
}
