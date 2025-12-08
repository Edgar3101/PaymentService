package com.ecommerce.payment.mappers;

import com.ecommerce.payment.dto.ProductdDTO;
import com.ecommerce.payment.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    public ProductdDTO productToProductDTO(Product product);
    public Product productDTOToProduct(ProductdDTO productDTO);
}
