package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.entity.Category;
import org.example.eticaret.service.CategoryService;

public class CategoryServiceMapper {

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
