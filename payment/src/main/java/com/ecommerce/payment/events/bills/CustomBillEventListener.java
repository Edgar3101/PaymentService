package com.ecommerce.payment.events.bills;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomBillEventListener implements ApplicationListener<CustomBillEvent> {

    @Override
    public void onApplicationEvent(CustomBillEvent event) {
        System.out.println("CustomBillEvent received for Order ID: " + event.getOrder().getId());
        log.info("Method NOT implemented yet!");
    }
}

