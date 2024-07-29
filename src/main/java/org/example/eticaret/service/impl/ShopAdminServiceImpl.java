package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.dto.ShopAdminDto;
import org.example.eticaret.entity.ShopAdmin;
import org.example.eticaret.repository.ShopAdminRepository;
import org.example.eticaret.service.ShopAdminService;
import org.example.eticaret.service.mapper.ShopAdminServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopAdminServiceImpl implements ShopAdminService {

    private final ShopAdminRepository shopAdminRepository;

    @Override
    public ShopAdminDto save(ShopAdminDto shopAdminDto) {
        ShopAdmin shopAdmin = ShopAdminServiceMapper.toEntity(shopAdminDto);
        shopAdmin = shopAdminRepository.save(shopAdmin);
        return ShopAdminServiceMapper.toDto(shopAdmin);
    }

    @Override
    public ShopAdminDto getShopAdmin(Long id) {
        Optional<ShopAdmin> shopAdmin = shopAdminRepository.findById(id);
        return shopAdmin.map(ShopAdminServiceMapper::toDto).orElse(null);
    }

    @Override
    public List<ShopAdminDto> getAllShopAdmin() {
        List<ShopAdmin> shopAdmins = shopAdminRepository.findAll();
        return shopAdmins.stream().map(ShopAdminServiceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ShopAdminDto update(ShopAdminDto shopAdminDto, Long id) {
        ShopAdmin shopAdmin = shopAdminRepository.findById(id)
                .map(existingShopAdmin -> {
                    existingShopAdmin.setName(shopAdminDto.getName());
                    existingShopAdmin.setSurname(shopAdminDto.getSurname());
                    existingShopAdmin.setEmail(shopAdminDto.getEmail());
                    existingShopAdmin.setPhoneNumber(shopAdminDto.getPhoneNumber());
                    existingShopAdmin.setAddress(shopAdminDto.getAddress());
                    existingShopAdmin.setPassword(shopAdminDto.getPassword());
                    existingShopAdmin.setShopName(shopAdminDto.getShopName());
                    return existingShopAdmin;
                })
                .orElseThrow(() -> new RuntimeException("ShopAdmin not found"));

        shopAdmin = shopAdminRepository.save(shopAdmin);
        return ShopAdminServiceMapper.toDto(shopAdmin);
    }

    @Override
    public void delete(Long id) {
        shopAdminRepository.deleteById(id);
    }


    @Override
    public ProductDto addProduct(ProductDto productDto) {

        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return null;
    }
}


