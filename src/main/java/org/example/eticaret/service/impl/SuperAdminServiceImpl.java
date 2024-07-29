package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.dto.SuperAdminDto;
import org.example.eticaret.entity.SuperAdmin;
import org.example.eticaret.repository.SuperAdminRepository;
import org.example.eticaret.service.SuperAdminService;
import org.example.eticaret.service.mapper.SuperAdminServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    private final SuperAdminRepository superAdminRepository;

    @Override
    public SuperAdminDto save(SuperAdminDto superAdminDto) {
        SuperAdmin superAdmin = SuperAdminServiceMapper.toEntity(superAdminDto);
        superAdmin = superAdminRepository.save(superAdmin);
        return SuperAdminServiceMapper.toDto(superAdmin);
    }

    @Override
    public SuperAdminDto get(Long id) {
        return superAdminRepository.findById(id)
                .map(SuperAdminServiceMapper::toDto)
                .orElseThrow(() -> new RuntimeException("SuperAdmin not found"));
    }



    @Override
    public List<SuperAdminDto> getAll() {
        List<SuperAdmin> superAdmins = superAdminRepository.findAll();
        return superAdmins.stream()
                .map(SuperAdminServiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        superAdminRepository.deleteById(id);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto dto) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }
}
