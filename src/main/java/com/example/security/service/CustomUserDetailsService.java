package com.example.security.service;

import com.example.security.entity.AppRole;
import com.example.security.entity.AppUser;
import com.example.security.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow();
        return new User(appUser.getUsername(), appUser.getPassword(), getAuthorities(appUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<AppRole> roles) {
        return
                roles.stream()
                        .map(AppRole::getName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet());
    }
}
