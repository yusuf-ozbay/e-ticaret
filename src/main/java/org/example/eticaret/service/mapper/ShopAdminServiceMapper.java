package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.ShopAdminDto;
import org.example.eticaret.entity.ShopAdmin;

public class ShopAdminServiceMapper {

    public static ShopAdmin toEntity(ShopAdminDto shopAdminDto) {
        return ShopAdmin.builder()
                .name(shopAdminDto.getName())
                .surname(shopAdminDto.getSurname())
                .email(shopAdminDto.getEmail())
                .phoneNumber(shopAdminDto.getPhoneNumber())
                .address(shopAdminDto.getAddress())
                .password(shopAdminDto.getPassword())
                .shopName(shopAdminDto.getShopName())
                .build();
    }

    public static ShopAdminDto toDto(ShopAdmin shopAdmin) {
        return ShopAdminDto.builder()
                .id(shopAdmin.getShopAdminId())
                .name(shopAdmin.getName())
                .surname(shopAdmin.getSurname())
                .email(shopAdmin.getEmail())
                .phoneNumber(shopAdmin.getPhoneNumber())
                .address(shopAdmin.getAddress())
                .password(shopAdmin.getPassword())
                .shopName(shopAdmin.getShopName())
                .build();
    }
}
