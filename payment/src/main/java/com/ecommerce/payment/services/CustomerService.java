package com.ecommerce.payment.services;

import com.ecommerce.payment.dto.CustomerDTO;
import com.ecommerce.payment.error.CustomerNotFound;
import com.ecommerce.payment.mappers.CustomerMapper;
import com.ecommerce.payment.model.Customer;
import com.ecommerce.payment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for managing customer-related business logic in the e-commerce payment system.
 *
 * <p>This service provides methods to retrieve, create, update, and manage customer data.
 * It acts as an intermediary between the controller layer and the repository layer, handling
 * business logic and data transformation operations.</p>
 *
 * <p>This class uses:</p>
 * <ul>
 *   <li>{@link CustomerRepository} for data persistence operations</li>
 *   <li>{@link CustomerMapper} for entity-to-DTO conversions</li>
 * </ul>
 */
@Service
public class CustomerService {

    /**
     * Repository for accessing customer data from the database.
     */
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Mapper for converting between {@link Customer} entities and {@link CustomerDTO} objects.
     */
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * Retrieves a paginated list of all customers from the database.
     *
     * <p>This method fetches customers using pagination to optimize performance
     * when dealing with large datasets. The results are converted to DTOs before
     * being returned to ensure separation between the persistence and presentation layers.</p>
     *
     * @param page the page number to retrieve (zero-based)
     * @param size the number of customers per page
     * @return a {@link List} of {@link CustomerDTO} objects representing the customers on the requested page
     */
    public List<CustomerDTO> getAllCustomers(int page, int size) {
        Page<Customer> customers = this.customerRepository.findAll(PageRequest.of(page, size));
        return customers.stream()
                .map(customer -> this.customerMapper.customerToCustomerDTO(customer))
                .toList();
    }

    /**
     * Retrieves a single customer by its string UUID identifier.
     *
     * <p>Converts the provided string to a {@link java.util.UUID} and queries the
     * {@link com.ecommerce.payment.repository.CustomerRepository} for the entity.
     * If no customer is found the method throws {@link com.ecommerce.payment.error.CustomerNotFound}
     * so callers (for example controllers) can map this to an HTTP 404 response.</p>
     *
     * <p>Note: {@link java.util.UUID#fromString(String)} will throw {@link IllegalArgumentException}
     * if the provided id is not a valid UUID string; callers should validate input or handle
     * that exception as appropriate.</p>
     *
     * @param id the customer's UUID as a String (expected non-null and in UUID format)
     * @return a {@link com.ecommerce.payment.dto.CustomerDTO} representing the requested customer
     * @throws com.ecommerce.payment.error.CustomerNotFound if a customer with the provided id does not exist
     * @throws IllegalArgumentException if the provided id is not a valid UUID string
     */
    public CustomerDTO getCustomerById(String id) throws CustomerNotFound, IllegalArgumentException {
        UUID uuid = UUID.fromString(id);
        Optional<Customer> customer = this.customerRepository.findById(uuid);
        if (customer.isEmpty()) {
            throw new CustomerNotFound("Customer Not found");
        }
        return this.customerMapper.customerToCustomerDTO(customer.get());
    }

}
