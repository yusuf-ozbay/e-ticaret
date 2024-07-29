package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.SuperAdminDto;
import org.example.eticaret.entity.SuperAdmin;

public class SuperAdminServiceMapper {

    public static SuperAdminDto toDto(SuperAdmin superAdmin) {
        return SuperAdminDto.builder()
                .superAdminId(superAdmin.getSuperAdminId())
                .username(superAdmin.getUsername())
                .password(superAdmin.getPassword())
                .build();
    }

    public static SuperAdmin toEntity(SuperAdminDto superAdminDto) {
        return SuperAdmin.builder()
                .superAdminId(superAdminDto.getSuperAdminId())
                .username(superAdminDto.getUsername())
                .password(superAdminDto.getPassword())
                .build();
    }
}
