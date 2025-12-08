package com.ecommerce.payment.dto;


import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

/**
 * Data Transfer Object representing a purchase order in the e-commerce payment system.
 *
 * <p>This DTO is used for transferring order data between layers of the application,
 * including order details such as unique identifier, description, total amount,
 * the associated customer, and the products included in the order.</p>
 *
 * <p>This class provides a simplified representation of the order entity without
 * JPA annotations, making it suitable for API responses and inter-layer communication.</p>
 */
public class OrderDTO {

    /**
     * Unique identifier for the order.
     */
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
     * Customer who owns the order.
     */
    private CustomerDTO customer;

    /**
     * List of products included in the order.
     */
    private List<ProductdDTO> products = new ArrayList<>();

    /**
     * Returns the unique identifier of the order.
     *
     * @return the {@link UUID} of the order, or {@code null} if not set
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
     * Returns the customer associated with the order.
     *
     * @return the {@link CustomerDTO} who owns the order
     */
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the order.
     *
     * @param customer the {@link CustomerDTO} to associate with this order
     */
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    /**
     * Returns the list of products included in the order.
     *
     * @return list of {@link ProductdDTO} objects
     */
    public List<ProductdDTO> getProducts() {
        return products;
    }

    /**
     * Sets the list of products included in the order.
     *
     * @param products list of {@link ProductdDTO} objects to assign
     */
    public void setProducts(List<ProductdDTO> products) {
        this.products = products;
    }

}
