package com.ecommerce.payment.mappers;


import com.ecommerce.payment.dto.CustomerDTO;
import com.ecommerce.payment.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);
    public Customer customerDTOToCustomer(CustomerDTO customerDTO);


}
