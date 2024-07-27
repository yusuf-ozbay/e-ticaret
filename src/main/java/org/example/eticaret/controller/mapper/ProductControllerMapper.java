package org.example.eticaret.controller.mapper;


import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.request.ProductRequest;
import org.example.eticaret.response.ProductResponse;

public class ProductControllerMapper {

    public static ProductDto toDto(ProductRequest productRequest) {
        return ProductDto.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .categoryId(productRequest.getCategoryId())
                .build();
    }

    public static ProductResponse toResponse(ProductDto productDto) {
        return ProductResponse.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .categoryId(productDto.getCategoryId())
                .build();
    }

}
