package org.example.eticaret.controller.mapper;

import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.request.CategoryRequest;
import org.example.eticaret.response.CategoryResponse;

public class CategoryControllerMapper {

    public static CategoryDto toDto(CategoryRequest categoryRequest) {
        return CategoryDto.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
    }

    public static CategoryResponse toResponse(CategoryDto categoryDto) {
        return CategoryResponse.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .productDtos(categoryDto.getProductDtos())
                .build();
    }




}
