package com.ecommerce.payment.controller;


import com.ecommerce.payment.dto.CustomerDTO;
import com.ecommerce.payment.error.CustomerNotFound;
import com.ecommerce.payment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller that exposes customer-related endpoints.
 *
 * <p>Provides endpoints to list customers with simple pagination and to retrieve a
 * single customer by id. This controller validates and clamps pagination parameters
 * and translates service-layer exceptions into appropriate HTTP responses.</p>
 *
 * <p>Endpoints:
 * <ul>
 *   <li>GET /customers - list customers with pagination</li>
 *   <li>GET /customers/{id} - retrieve a customer by UUID</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    /** Default page size used when the client does not provide a `size` parameter. */
    private static final int DEFAULT_PAGE_SIZE = 20;

    /** Maximum allowed page size to protect the API from very large responses. */
    private static final int MAX_PAGE_SIZE = 100;

    /** Default page number when the client does not provide a `page` parameter (1-based). */
    private static final int DEFAULT_PAGE_NUMBER = 1;

    /** Service that contains customer business logic. */
    @Autowired
    private CustomerService customerService;

    /**
     * Retrieve a paginated list of customers.
     *
     * <p>Reads optional query parameters `page` and `size`. The controller applies
     * defaults when parameters are missing and clamps `size` to {@value #MAX_PAGE_SIZE}
     * to prevent excessive payloads. Note that this controller treats `page` as
     * 1-based (first page = 1) and forwards the provided value directly to the service.
     * If you wish the service to receive zero-based pages, convert the value before
     * calling the service.</p>
     *
     * @param page optional one-based page number (first page = 1). If absent, {@value #DEFAULT_PAGE_NUMBER} is used.
     * @param size optional page size. If absent, {@value #DEFAULT_PAGE_SIZE} is used. The value is clamped to {@value #MAX_PAGE_SIZE}.
     * @return HTTP 200 with a paginated list of {@link CustomerDTO} objects in the response body
     */
    @GetMapping("")
    public ResponseEntity<?> getAllCustomers(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        int pageNumber = page.orElse(DEFAULT_PAGE_NUMBER);
        int sizeNumber = size.orElse(DEFAULT_PAGE_SIZE);
        if (sizeNumber > MAX_PAGE_SIZE) sizeNumber = MAX_PAGE_SIZE;
        return ResponseEntity.ok(this.customerService.getAllCustomers(pageNumber, sizeNumber));
    }

    /**
     * Retrieve a single customer by its UUID identifier.
     *
     * <p>Calls the service to fetch the customer. If the customer cannot be found
     * the service throws {@link CustomerNotFound} which this controller maps to
     * HTTP 404 Not Found. Any unexpected exception is mapped to HTTP 500 Internal Server Error.</p>
     *
     * @param id the customer's UUID as a String (expected non-null and in UUID format)
     * @return HTTP 200 with the {@link CustomerDTO} in the response body when found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        try{
            CustomerDTO customer = this.customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        }catch (CustomerNotFound error) {
            return ResponseEntity.notFound().build();
        }catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Invalid UUID format for customer ID");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
