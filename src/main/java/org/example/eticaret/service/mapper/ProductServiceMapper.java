package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.entity.Product;
import org.example.eticaret.service.CategoryService;

public class ProductServiceMapper {

    public static Product toEntity( CategoryService categoryService ,ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(categoryService.getEntity(productDto.getCategoryId()))
                .stock(productDto.getStock())
                .build();
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory().getCategoryId())
                .build();
    }
}
