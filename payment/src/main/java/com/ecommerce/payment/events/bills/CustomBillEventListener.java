package com.ecommerce.payment.events.bills;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Listener responsible for handling billing-related application events.
 *
 * <p>This listener reacts to {@link CustomBillEvent} instances and performs a
 * mock billing process. In the current implementation the action is limited to
 * logging: when an event arrives the listener logs receipt and then logs that
 * a bill was sent to the customer. Replace the logging calls with real billing
 * provider integrations when moving to production.</p>
 *
 * Contract:
 * <ul>
 *   <li>Inputs: {@link CustomBillEvent} containing an order to bill.</li>
 *   <li>Outputs: informational logs indicating the handling result.</li>
 *   <li>Error modes: any runtime exception thrown during processing will
 *       propagate; the current implementation does not attempt retries.</li>
 * </ul>
 *
 * Usage example:
 * <pre>
 * // eventPublisher.publishEvent(new CustomBillEvent(this, order));
 * </pre>
 *
 * @see com.ecommerce.payment.events.bills.CustomBillEvent
 * @since 1.0
 */
@Slf4j
@Component
public class CustomBillEventListener implements ApplicationListener<CustomBillEvent> {

    /**
     * Handle the incoming {@link CustomBillEvent}.
     *
     * <p>The method logs the receipt of the event and simulates sending a bill to
     * the customer associated with the order contained in the event. The event
     * argument is expected to provide access to an order via {@code event.getOrder()}.
     *</p>
     *
     * @param event the billing event to handle; must not be {@code null}. The
     *              event should contain a fully populated order with an id
     *              accessible via {@code event.getOrder().getId()}.
     */
    @Override
    public void onApplicationEvent(CustomBillEvent event) {
        log.info("Received CustomBillEvent for Order ID: {}", event.getOrder().getId());
        // We can implement a mock billing process here
        log.info("Bill sent to the customer for Order ID: {}", event.getOrder().getId());
    }
}
