package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.entity.Product;
import org.example.eticaret.service.CategoryService;

public class ProductServiceMapper {

    public static Product toEntity( CategoryService categoryService ,ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(categoryService.getEntity(productDto.getCategoryId()))
                .build();
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .build();
    }
}
