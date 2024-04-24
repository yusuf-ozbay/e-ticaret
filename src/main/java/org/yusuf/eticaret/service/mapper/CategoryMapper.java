package org.yusuf.eticaret.service.mapper;

import org.yusuf.eticaret.dto.CategoryDto;
import org.yusuf.eticaret.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    public static CategoryDto toDto(Category category){
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        category.setProducts(category.getProducts());
        return categoryDto;

    }
}
