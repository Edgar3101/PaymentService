package com.ecommerce.payment.services;

import com.ecommerce.payment.dto.CustomerDTO;
import com.ecommerce.payment.mappers.CustomerMapper;
import com.ecommerce.payment.model.Customer;
import com.ecommerce.payment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDTO> getAllCustomers(int page, int size) {
        Page<Customer> customers = this.customerRepository.findAll(PageRequest.of(page, size));
        return customers.stream()
                .map(customer -> this.customerMapper.customerToCustomerDTO(customer))
                .toList();
    }

}
