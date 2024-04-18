package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.CategoryDto;
import org.yusuf.eticaret.entity.Category;
import org.yusuf.eticaret.repository.CategoryRepository;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category findById(long id){
        Category category=categoryRepository.findById(id).get();

        return category;

    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category =toEntity(categoryDto);
        category = categoryRepository.save(category);
        return toDto(category);
    }

    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    public CategoryDto toDto(Category category){
        CategoryDto categoryDto =new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        category.setProducts(category.getProducts());
        return categoryDto;

    }
}
