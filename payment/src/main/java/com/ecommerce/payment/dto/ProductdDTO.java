package com.ecommerce.payment.dto;

import java.util.UUID;

/**
 * Data Transfer Object representing a product in the e-commerce payment system.
 *
 * <p>This DTO is used for transferring product data between layers of the application,
 * including product information such as identifier, name, price, description, stock
 * quantity, discount percentage, and the owning order if the product is associated
 * with one.</p>
 *
 * <p>This class provides a simplified representation of the product entity without
 * JPA annotations, making it suitable for API responses and inter-layer communication.</p>
 */
public class ProductdDTO {

    /**
     * Unique identifier for the product.
     */
    private UUID id;

    /**
     * Human-readable product name.
     */
    private String name;

    /**
     * Product price in the application's currency.
     * <p>Consider using {@link java.math.BigDecimal} for precise monetary
     * calculations if needed.</p>
     */
    private double price;

    /**
     * Product description, typically shown to customers.
     */
    private String description;

    /**
     * Current stock quantity available for this product.
     */
    private int stockQuantity;

    /**
     * Percentage discount to apply to this product price (0-100).
     */
    private int percentageDiscount;

    /**
     * Owning order for this product, if any.
     */
    private OrderDTO order;

    /**
     * Returns the unique identifier for the product.
     *
     * @return the {@link UUID} of the product, or {@code null} if not set
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the product.
     *
     * @param id the {@link UUID} to assign
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Returns the product name.
     *
     * @return the name as a {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name human-readable product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product price.
     *
     * @return the price as a {@code double}
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price product price in the application's currency
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the product description.
     *
     * @return the description as a {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the product description.
     *
     * @param description descriptive text for the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the available stock quantity for the product.
     *
     * @return the stock quantity as an {@code int}
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets the available stock quantity for the product.
     *
     * @param stockQuantity non-negative integer representing available units
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Returns the discount percentage for the product.
     *
     * @return the discount percentage as an {@code int}
     */
    public int getPercentageDiscount() {
        return percentageDiscount;
    }

    /**
     * Sets the discount percentage for the product.
     *
     * @param percentageDiscount integer value between 0 and 100
     */
    public void setPercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    /**
     * Returns the order associated with this product.
     *
     * @return the {@link OrderDTO} to which this product belongs, or {@code null} if not associated
     */
    public OrderDTO getOrder() {
        return order;
    }

    /**
     * Associates this product with an order.
     *
     * @param order the {@link OrderDTO} to associate, or {@code null} to disassociate
     */
    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}
