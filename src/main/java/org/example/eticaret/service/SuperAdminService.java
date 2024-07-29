package org.example.eticaret.service;

import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.dto.SuperAdminDto;

import java.util.List;

public interface SuperAdminService {
    SuperAdminDto save(SuperAdminDto superAdminDto);
    SuperAdminDto get(Long id);

    CategoryDto saveCategory(CategoryDto dto);

    List<CategoryDto> getAllCategory();

    List<SuperAdminDto> getAll();

    void delete(Long id);
}
