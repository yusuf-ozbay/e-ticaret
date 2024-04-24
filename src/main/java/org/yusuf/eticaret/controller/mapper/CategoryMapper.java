package org.yusuf.eticaret.controller.mapper;

import org.yusuf.eticaret.dto.CategoryDto;
import org.yusuf.eticaret.request.CategoryRequest;
import org.yusuf.eticaret.response.CategoryResponse;

public class CategoryMapper {

    public static CategoryResponse toResponse(CategoryDto categoryDto){
        CategoryResponse categoryResponse =new CategoryResponse();
        categoryResponse.setId(categoryDto.getId());
        categoryResponse.setName(categoryDto.getName());
        categoryResponse.setDescription(categoryDto.getDescription());
        categoryResponse.setProducts(categoryDto.getProducts());
        return categoryResponse;

    }

    public static CategoryDto toDto(CategoryRequest categoryRequest){
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setName(categoryRequest.getName());
        categoryDto.setDescription(categoryRequest.getDescription());
        return categoryDto;

    }
}
