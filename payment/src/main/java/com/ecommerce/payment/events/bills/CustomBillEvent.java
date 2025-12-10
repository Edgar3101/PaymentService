package com.ecommerce.payment.events.bills;

import com.ecommerce.payment.model.Order;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomBillEvent extends ApplicationEvent {

    private final Order order;

    public CustomBillEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
