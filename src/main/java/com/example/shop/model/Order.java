package com.example.shop.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "order_date")
    private String orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Order() {
    }

    public Order(int id, List<OrderItem> orderItems, String email, String address, String name, String orderDate) {
        this.id = id;
        this.orderItems = orderItems;
        this.email = email;
        this.address = address;
        this.name = name;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
