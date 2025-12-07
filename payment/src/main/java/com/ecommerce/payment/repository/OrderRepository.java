package com.ecommerce.payment.repository;

import org.springframework.data.repository.CrudRepository;
import com.ecommerce.payment.model.Order;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
