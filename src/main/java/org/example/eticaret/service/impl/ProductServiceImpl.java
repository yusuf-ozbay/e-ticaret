package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.entity.Product;
import org.example.eticaret.repository.ProductRepository;
import org.example.eticaret.service.CategoryService;
import org.example.eticaret.service.ProductService;
import org.example.eticaret.service.mapper.ProductServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductServiceMapper.toEntity(categoryService,productDto );
        product = productRepository.save(product);
        return ProductServiceMapper.toDto(product);
    }

    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductServiceMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(ProductServiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product updatedProduct = productRepository.save(product);
        return ProductServiceMapper.toDto(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
