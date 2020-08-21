package com.mesh.test.repository.entity;

import com.mesh.test.model.ProfilesSetRequestDTO;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_sequence")
    @SequenceGenerator(name = "profile_sequence", sequenceName = "profile_seq")
    private @Valid Integer id;

    private @Valid String name;

    @Valid
    @Column(unique = true)
    private String email;

    private @Valid Integer age;

    private @Valid String created;

    public Profile(@Valid String name, @Valid String email, @Valid Integer age, @Valid String created) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.created = created;
    }

    public Profile(ProfilesSetRequestDTO profile, String created) {
        this.name = profile.getName();
        this.email = profile.getEmail();
        this.age = profile.getAge();
        this.created = created;
    }

    public Profile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
