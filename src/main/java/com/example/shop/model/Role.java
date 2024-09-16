package com.example.shop.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name", nullable = false)  // Make sure the column name matches
    private String roleName;  // This should match the attribute used in the repository query

    // Constructors, Getters, and Setters

    public Role() {}

    public Role(String name) {
        this.roleName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String name) {
        this.roleName = name;
    }
}