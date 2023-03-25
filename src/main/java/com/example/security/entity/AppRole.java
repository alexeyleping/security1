package com.example.security.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "approle")
public class AppRole implements GrantedAuthority {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "appusers")
    @ManyToMany(mappedBy = "appRoles")
    private Set<AppUser> appusers;

    public AppRole() {
    }

    public AppRole(UUID id, String name, Set<AppUser> appusers) {
        this.id = id;
        this.name = name;
        this.appusers = appusers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getAppusers() {
        return appusers;
    }

    public void setAppusers(Set<AppUser> appusers) {
        this.appusers = appusers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole appRole = (AppRole) o;
        return Objects.equals(id, appRole.id) && Objects.equals(name, appRole.name) && Objects.equals(appusers, appRole.appusers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, appusers);
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appusers=" + appusers +
                '}';
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
