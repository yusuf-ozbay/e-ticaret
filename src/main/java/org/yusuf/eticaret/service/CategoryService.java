package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.CategoryDto;
import org.yusuf.eticaret.entity.Category;
import org.yusuf.eticaret.repository.CategoryRepository;
import org.yusuf.eticaret.service.mapper.CategoryMapper;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;



    public Category findById(long id){
        Category category=categoryRepository.findById(id).get();
        return category;
    }



    public CategoryDto save(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.toDto(category);
    }

}
