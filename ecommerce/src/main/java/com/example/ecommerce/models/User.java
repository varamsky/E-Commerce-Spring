package com.example.ecommerce.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    @Column
    private Boolean verified;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime modifiedAt;

    @OneToMany(mappedBy = "user")
    private Set<CartItem> userCartItems;

    @OneToMany(mappedBy = "user")
    private Set<Order> userOrders;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(final Boolean verified) {
        this.verified = verified;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Set<CartItem> getUserCartItems() {
        return userCartItems;
    }

    public void setUserCartItems(final Set<CartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }

    public Set<Order> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(final Set<Order> userOrders) {
        this.userOrders = userOrders;
    }

}