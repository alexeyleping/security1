package com.example.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "app_role")
public class AppRole {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public AppRole() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
