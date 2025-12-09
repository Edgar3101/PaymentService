package com.ecommerce.payment.controller;


import com.ecommerce.payment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getAllCustomers(10, 1));
    }
}
