package com.ecommerce.payment.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object representing a customer in the e-commerce payment system.
 *
 * <p>This DTO is used for transferring customer data between layers of the application,
 * including customer identity, contact information, and associated orders.</p>
 *
 * <p>This class provides a simplified representation of the customer entity without
 * JPA annotations, making it suitable for API responses and inter-layer communication.</p>
 */
public class CustomerDTO {

    /**
     * Unique identifier for the customer.
     */
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
     * List of orders associated with this customer.
     */
    private List<OrderDTO> orders = new ArrayList<>();

    /**
     * Returns the unique identifier of the customer.
     *
     * @return the {@link UUID} of the customer, or {@code null} if not set
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
     * Returns the list of orders associated with this customer.
     *
     * @return list of {@link OrderDTO} objects
     */
    public List<OrderDTO> getOrders() {
        return orders;
    }

    /**
     * Sets the list of orders associated with this customer.
     *
     * @param orders list of {@link OrderDTO} objects to assign
     */
    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
