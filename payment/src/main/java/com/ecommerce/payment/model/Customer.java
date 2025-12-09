package com.ecommerce.payment.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

/**
 * Represents a customer in the e-commerce payment system.
 *
 * <p>This entity stores customer identity and contact information and keeps a
 * reference to the orders associated with the customer.</p>
 *
 * <p>The JPA relationships used are:</p>
 * <ul>
 *   <li>{@code @OneToMany} to {@link Order} mapped by {@code customer} with cascade {@link CascadeType#ALL}.</li>
 * </ul>
 */
@Entity
public class Customer {

    /**
     * Unique identifier for the customer. Automatically generated as a {@link UUID}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Customer's full name.
     */
    private String name;

    /**
     * Customer's email address used for contact and notifications.
     */
    private String email;

    /**
     * Customer's phone number used for contact.
     */
    private String phoneNumber;

    /**
     * Timestamp when the customer was created. Stored as {@link LocalDateTime}.
     */
    @CreationTimestamp
    @Column(updatable = false, name="created_at")
    private LocalDateTime createdAt;

    /**
     * Active/inactive flag for the customer account.
     */
    private boolean status;


    /**
     * Orders associated with this customer. One-to-many relation with full cascade
     * so persistence/removal operations are propagated to related orders.
     */
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    /**
     * Returns the unique identifier of the customer.
     *
     * @return the {@link UUID} of the customer, or {@code null} if not yet generated
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the customer.
     *
     * @param id the {@link UUID} to assign
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Returns the customer's full name.
     *
     * @return the name as a {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's full name.
     *
     * @param name full name to assign
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the customer's email address.
     *
     * @return the email as a {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the customer's email address.
     *
     * @param email email address to assign
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the customer's phone number.
     *
     * @return the phone number as a {@link String}
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the customer's phone number.
     *
     * @param phoneNumber phone number to assign
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the creation timestamp for the customer.
     *
     * @return creation time as {@link LocalDateTime}
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp for the customer.
     *
     * @param createdAt creation time to assign
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the status of the customer account.
     *
     * @return {@code true} if active, {@code false} otherwise
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status of the customer account.
     *
     * @param status {@code true} to mark active, {@code false} to mark inactive
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Returns the list of orders associated with the customer.
     *
     * @return a mutable list of {@link Order}; may be empty but never {@code null}
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Replaces the customer's orders list.
     *
     * @param orders new list of {@link Order}; if {@code null} is passed,
     *               the internal list will be set to {@code null}
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
