package org.example.eticaret.service;

import org.example.eticaret.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);
    ProductDto getProduct(int id);
    List<ProductDto> getAll();
    ProductDto update(Long id, ProductDto productDto);
    void  delete(Long id);
}
