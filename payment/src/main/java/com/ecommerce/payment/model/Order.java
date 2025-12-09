package com.ecommerce.payment.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a purchase order within the e-commerce payment system.
 *
 * <p>This entity persists basic order information such as its unique identifier
 * (UUID), description, total amount, creation time, the associated customer,
 * and the products included in the order.</p>
 *
 * <p>The JPA relationships used are:</p>
 * <ul>
 *   <li>{@code @ManyToOne} to {@link Customer} (foreign key `customer_id`, non-null)</li>
 *   <li>{@code @OneToMany} to {@link Product} with cascade {@link CascadeType#ALL} and
 *       inverse mapping via the {@code order} property on the {@link Product} entity</li>
 * </ul>
 */
@Entity
public class Order {

    /**
     * Unique identifier for the order. Automatically generated as a {@link UUID}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    /**
     * Short description for the order (for example, internal notes or summary).
     */
    private String description;

    /**
     * Total amount for the order in the application's currency.
     * <p>Using {@code double} may be sufficient for some cases, but consider
     * {@link java.math.BigDecimal} for precise monetary calculations.</p>
     */
    private double amount;

    /**
     * Time when the order was created. Currently stored as {@link LocalTime}.
     * <p>Note: this field represents time only; if date+time is required,
     * consider using {@link java.time.Instant} or {@link java.time.LocalDateTime}.</p>
     */
    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private LocalTime createdAt;

    /**
     * Customer who owns the order. Many-to-one relation to {@link Customer}.
     * The foreign key column is named {@code customer_id} and is not nullable.
     */
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    /**
     * List of products included in the order. One-to-many relation with full
     * cascade to propagate persistence/removal operations.
     */
    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();


    /**
     * Returns the unique identifier of the order.
     *
     * @return the {@link UUID} of the order, or {@code null} if not yet generated
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the order.
     *
     * @param id the {@link UUID} to assign
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Returns the order description.
     *
     * @return the description as a {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the order description.
     *
     * @param description descriptive text for the order
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the total amount of the order.
     *
     * @return the amount as a {@code double}
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the total amount of the order.
     *
     * @param amount total amount to assign
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the creation time of the order.
     *
     * @return creation time as {@link LocalTime}
     */
    public LocalTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation time of the order.
     *
     * @param createdAt creation time to assign
     */
    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the customer associated with the order.
     *
     * @return the {@link Customer} who owns the order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Assigns the customer who owns the order.
     *
     * @param customer instance of {@link Customer} to associate
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the list of products included in the order.
     *
     * @return a mutable list of {@link Product}; may be empty but never {@code null}
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Replaces the order's product list.
     *
     * @param products new list of {@link Product}; if {@code null} is passed,
     *                 the internal list will be set to {@code null}
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}