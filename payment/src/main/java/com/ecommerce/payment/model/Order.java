package com.ecommerce.payment.model;


import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String description;
    private double amount;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalTime createdAt;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
