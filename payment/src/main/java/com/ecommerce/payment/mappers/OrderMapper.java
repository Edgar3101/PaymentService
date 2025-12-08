package com.ecommerce.payment.mappers;

import com.ecommerce.payment.dto.OrderDTO;
import com.ecommerce.payment.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderDTO orderToOrderDTO(Order order);
    public Order orderDTOToOrder(OrderDTO orderDTO);

    List<OrderDTO> ordersToOrderDTOs(List<Order> orders);
    List<Order> orderDTOsToOrders(List<OrderDTO> orderDTOs);
}
