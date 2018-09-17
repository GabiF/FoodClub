package com.user.service.food.club.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant {

    public Restaurant() {
        // Needed by JPA
    }

    @Id
    @GeneratedValue
    private long Id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String address;

    @NotNull
    @Size(max = 300)
    private String description;

    @NotNull
    private String postcode;

    @NotNull
    private Boolean role;

    public long getId() {
        return Id;
    }

    public Restaurant(String name, String email, String address, String description, String postcode, Boolean role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.description = description;
        this.postcode = postcode;
        this.role = role;
    }

    public void setId(long id) {
        Id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", postcode='" + postcode + '\'' +
                ", role=" + role +
                '}';
    }
}
