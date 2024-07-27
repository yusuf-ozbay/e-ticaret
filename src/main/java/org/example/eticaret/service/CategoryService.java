package org.example.eticaret.service;

import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto getCategory(Long id);

    Category getEntity(Long id);

    List<CategoryDto> getAll();

    CategoryDto update(Long id, CategoryDto categoryDto);

    void delete(Long id);



}
