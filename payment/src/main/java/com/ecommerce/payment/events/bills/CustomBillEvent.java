package com.ecommerce.payment.events.bills;

import com.ecommerce.payment.model.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * Event published when an order requires billing.
 *
 * <p>This event carries an {@link Order} that should be processed by billing
 * listeners (for example, {@link CustomBillEventListener}). The class is a
 * lightweight wrapper around Spring's {@link ApplicationEvent} so it can be
 * published through the application eventing system.</p>
 *
 * Contract:
 * <ul>
 *   <li>Inputs: a non-null {@link Order} instance and the event source (publisher).</li>
 *   <li>Outputs: none by itself — listeners perform side effects such as
 *       sending invoices or charging a payment provider.</li>
 *   <li>Error modes: consumers of this event should validate the order; the
 *       publisher may still create the event with an invalid order which
 *       should be handled by listeners.</li>
 * </ul>
 *
 * Usage example:
 * <pre>
 * // eventPublisher.publishEvent(new CustomBillEvent(this, order));
 * </pre>
 *
 * @see com.ecommerce.payment.events.bills.CustomBillEventListener
 * @since 1.0
 */
@Getter
@Setter
public class CustomBillEvent extends ApplicationEvent {

    private final Order order;

    /**
     * Create a new billing event for the supplied order.
     *
     * <p>The {@code source} parameter should typically be the publishing
     * component (for example, a service). The {@code order} parameter is the
     * order to be billed and should be non-null; listeners rely on its presence
     * to perform billing operations.</p>
     *
     * @param source the object on which the event initially occurred (typically the publisher)
     * @param order  the order to bill; expected to be non-null and contain at least an id
     */
    public CustomBillEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
