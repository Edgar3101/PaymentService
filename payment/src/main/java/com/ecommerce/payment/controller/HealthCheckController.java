package com.ecommerce.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping()
    public ResponseEntity<?> healthCheck() {
        LocalDateTime timeStamp = LocalDateTime.now();
        return ResponseEntity.ok("Payment Service is healthy at " + timeStamp);
    }
}
