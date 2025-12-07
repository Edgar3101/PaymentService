package com.ecommerce.payment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private double price;
    private String description;
    private int stockQuantity;
    private int percentageDiscount;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setPercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
