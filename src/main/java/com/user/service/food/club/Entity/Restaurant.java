package com.user.service.food.club.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Restaurant {

    public Restaurant() {
        // Needed by JPA
    }

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty(message = "Please provide the name of the restaurant")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail address")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @NotNull
    @Transient
    private String password;

    public Restaurant(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
