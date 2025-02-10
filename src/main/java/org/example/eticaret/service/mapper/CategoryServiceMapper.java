package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.entity.Category;

public class CategoryServiceMapper {

    public static Category toEntity(CategoryDto categoryDto) {

        Category category=new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getCategoryId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
