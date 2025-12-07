package com.ecommerce.payment.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a product available for purchase in the e-commerce system.
 *
 * <p>This entity stores basic product information such as identifier, name,
 * price, description, stock quantity, discount percentage, creation timestamp
 * and the owning order if the product is associated with one.</p>
 *
 * <p>The JPA relationships used are:</p>
 * <ul>
 *   <li>{@code @ManyToOne} to {@link Order} with a foreign key column {@code order_id}.</li>
 * </ul>
 */
@Entity
public class Product {

    /**
     * Unique identifier for the product. Automatically generated as a {@link UUID}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
     * Timestamp when the product was created. Stored as {@link LocalDateTime}.
     */
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    /**
     * Owning order for this product, if any. Many-to-one relation to {@link Order}.
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    /**
     * Sets the unique identifier for the product.
     *
     * @param id the {@link UUID} to assign
     */
    public void setId(UUID id) {
        this.id = id;
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
     * Sets the product price.
     *
     * @param price product price in the application's currency
     */
    public void setPrice(double price) {
        this.price = price;
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
     * Sets the available stock quantity for the product.
     *
     * @param stockQuantity non-negative integer representing available units
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
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
     * Sets the creation timestamp for the product.
     *
     * @param createdAt creation time as {@link LocalDateTime}
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Associates this product with an order.
     *
     * @param order the {@link Order} to associate, or {@code null} to disassociate
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Returns the unique identifier for the product.
     *
     * @return the {@link UUID} of the product, or {@code null} if not yet generated
     */
    public UUID getId() {
        return id;
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
     * Returns the product price.
     *
     * @return the price as a {@code double}
     */
    public double getPrice() {
        return price;
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
     * Returns the current stock quantity for the product.
     *
     * @return available units as an {@code int}
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Returns the discount percentage applied to the product.
     *
     * @return discount percentage as an {@code int} between 0 and 100
     */
    public int getPercentageDiscount() {
        return percentageDiscount;
    }

    /**
     * Returns the creation timestamp for the product.
     *
     * @return creation time as {@link LocalDateTime}
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the order associated with this product, if any.
     *
     * @return the owning {@link Order}, or {@code null} if not associated
     */
    public Order getOrder() {
        return order;
    }

}
