package com.mesh.test.repository.entity;

import com.mesh.test.model.UserDTO;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    private Integer id;

    @Valid
    @Column(unique = true)
    private String username;

    private @Valid String password;

    public UserEntity(Integer id, @Valid String username, @Valid String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserEntity(@Valid String username, @Valid String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
