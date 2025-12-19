package com.ecommerce.payment.services;

import com.ecommerce.payment.dto.OrderDTO;
import com.ecommerce.payment.events.bills.CustomBillEvent;
import com.ecommerce.payment.mappers.OrderMapper;
import com.ecommerce.payment.model.Order;
import com.ecommerce.payment.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Service layer responsible for order-related business logic in the e-commerce payment system.
 *
 * <p>This service provides operations to create and manage orders. It acts as an
 * intermediary between controllers and the persistence layer, handling entity-to-DTO
 * mapping, persistence operations and domain events publishing.</p>
 *
 * <p>Collaborators:
 * <ul>
 *   <li>{@link OrderRepository} for data persistence operations</li>
 *   <li>{@link OrderMapper} for converting between {@link Order} entities and {@link OrderDTO} objects</li>
 *   <li>{@link ApplicationEventPublisher} for publishing domain events such as {@link CustomBillEvent}</li>
 * </ul>
 * </p>
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ApplicationEventPublisher publisher;


    /**
     * Create a new order from the provided {@link OrderDTO} and persist it.
     *
     * <p>The method converts the incoming DTO to a persistence entity using {@link OrderMapper},
     * saves it using {@link OrderRepository}, logs the creation and publishes a
     * {@link CustomBillEvent} so downstream listeners can react (for example billing
     * or notification components).</p>
     *
     * <p>Note: The method logs the created order id and the event publication. Any mapping
     * or persistence exception will propagate to the caller and should be handled by
     * the controller or a global exception handler to produce the appropriate HTTP response.</p>
     *
     * @param orderDTO the order data transfer object containing the details to create the order (must not be null)
     * @return the persisted {@link OrderDTO} representing the created order, including generated identifiers
     * @throws IllegalArgumentException if the provided {@code orderDTO} is invalid for mapping (implementation-specific)
     * @throws RuntimeException for persistence or event publishing failures
     */
    public OrderDTO createOrder(OrderDTO orderDTO) throws IllegalArgumentException, RuntimeException
    {
        // We save the order entity converted from DTO
        Order order = this.orderRepository.save(this.orderMapper.orderDTOToOrder(orderDTO));
        log.info("Order created with id: {}", order.getId());
        // Publish the CustomBillEvent for the created order
        this.publisher.publishEvent(new CustomBillEvent(this, order));
        log.info("CustomBillEvent published for Order id: {}", order.getId());
        // Return the saved order as DTO
        return this.orderMapper.orderToOrderDTO(order);
    }


}
