package org.example.eticaret.controller.mapper;

import org.example.eticaret.dto.SuperAdminDto;
import org.example.eticaret.request.SuperAdminRequest;
import org.example.eticaret.response.SuperAdminResponse;

public class SuperAdminControllerMapper {

    public static SuperAdminDto toDto(SuperAdminRequest superAdminRequest) {
        return SuperAdminDto.builder()
                .superAdminId(superAdminRequest.getSuperAdminId())
                .username(superAdminRequest.getUsername())
                .password(superAdminRequest.getPassword())
                .build();
    }

    public static SuperAdminResponse toResponse(SuperAdminDto superAdminDto) {
        return SuperAdminResponse.builder()
                .superAdminId(superAdminDto.getSuperAdminId())
                .username(superAdminDto.getUsername())
                .password(superAdminDto.getPassword())
                .build();
    }
}
