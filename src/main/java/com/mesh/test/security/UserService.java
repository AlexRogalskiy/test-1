package com.mesh.test.security;

import com.mesh.test.repository.UserEntityRepository;
import com.mesh.test.repository.entity.UserEntity;
import com.mesh.test.webapi.exception.NotFoundRestException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserEntityRepository repository;

    public UserService(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundRestException("Пользователь не найден"));

        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.singletonList(authority));
    }
}
