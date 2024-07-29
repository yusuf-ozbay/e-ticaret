package org.example.eticaret.controller.mapper;

import org.example.eticaret.dto.ShopAdminDto;
import org.example.eticaret.request.ShopAdminRequest;
import org.example.eticaret.response.ShopAdminResponse;

public class ShopAdminControllerMapper {

    public static ShopAdminDto toDto(ShopAdminRequest shopAdminRequest) {
        return ShopAdminDto.builder()
                .name(shopAdminRequest.getName())
                .surname(shopAdminRequest.getSurname())
                .email(shopAdminRequest.getEmail())
                .phoneNumber(shopAdminRequest.getPhoneNumber())
                .address(shopAdminRequest.getAddress())
                .password(shopAdminRequest.getPassword())
                .shopName(shopAdminRequest.getShopName())
                .build();
    }

    public static ShopAdminResponse toResponse(ShopAdminDto shopAdminDto) {
        return ShopAdminResponse.builder()
                .id(shopAdminDto.getId())
                .name(shopAdminDto.getName())
                .surname(shopAdminDto.getSurname())
                .email(shopAdminDto.getEmail())
                .phoneNumber(shopAdminDto.getPhoneNumber())
                .address(shopAdminDto.getAddress())
                .password(shopAdminDto.getPassword())
                .shopName(shopAdminDto.getShopName())
                .build();
    }
}
